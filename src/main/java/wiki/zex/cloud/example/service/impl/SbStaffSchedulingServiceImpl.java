package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wiki.zex.cloud.example.entity.*;
import wiki.zex.cloud.example.exception.ParameterException;
import wiki.zex.cloud.example.req.StaffSchedulingReq;
import wiki.zex.cloud.example.service.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@Slf4j
public class SbStaffSchedulingServiceImpl implements ISbStaffSchedulingService {

    @Autowired
    private ISbStaffTeamSchedulingService iSbStaffTeamSchedulingService;
    @Autowired
    private ISbStaffGroupSchedulingService iSbStaffGroupSchedulingService;

    @Autowired
    private ISbStaffTeamService iSbStaffTeamService;

    @Autowired
    private ISbRouteItemService iSbRouteItemService;


    @Autowired
    private ISbStaffGroupService iSbStaffGroupService;

    @Autowired
    private ISbShiftGroupService iSbShiftGroupService;

    @Autowired
    private ISbStaffService iSbStaffService;

    @Override
    @Transactional
    public void generate(StaffSchedulingReq req) {

        List<SbStaffTeamScheduling> teamSchedulingList = new ArrayList<>();
        List<SbStaffGroupScheduling> groupSchedulingList = new ArrayList<>();

        long diffValue = req.getEndAt().toEpochDay() - req.getStartAt().toEpochDay();

        //获取前一天的机队排班信息
        List<SbStaffTeamScheduling> yesterdayTeamScheduling = iSbStaffTeamSchedulingService.list(new LambdaQueryWrapper<SbStaffTeamScheduling>().eq(SbStaffTeamScheduling::getDate, req.getStartAt().minusDays(1)));
        //获取机队轮换信息
        List<SbStaffTeam> staffTeams = iSbStaffTeamService.list(new LambdaQueryWrapper<SbStaffTeam>().orderByAsc(SbStaffTeam::getId));
        if (CollectionUtils.isEmpty(staffTeams)){
            throw new ParameterException("请先添加机队信息");
        }
        //获取班组信息
        List<SbShiftGroup> shiftGroups = iSbShiftGroupService.list();
        if (CollectionUtils.isEmpty(shiftGroups)){
            throw new ParameterException("请先维护班次组信息");
        }
        //通过前一天的排班数据 进行重新排序
        staffTeams = sortTeams(staffTeams, shiftGroups, yesterdayTeamScheduling);

        //机队轮换索引
        int teamRotateIndex = 0;
        for (int i = 0; i <= diffValue; i++) {
            //每天处理一次
            LocalDate curDate = req.getStartAt().plusDays(i);
            //班次组和机队排班
            for (SbShiftGroup shiftGroup : shiftGroups) {
                assert staffTeams != null;
                SbStaffTeam rotateTeam = getRotateTeam(staffTeams, teamRotateIndex);
                teamRotateIndex++;
                SbStaffTeamScheduling staffTeamScheduling = new SbStaffTeamScheduling();
                staffTeamScheduling.setShiftGroupId(shiftGroup.getId());
                staffTeamScheduling.setDate(curDate);
                staffTeamScheduling.setStaffTeamId(rotateTeam.getId());
                //存储机队排班信息
                teamSchedulingList.add(staffTeamScheduling);
                //机组和交路排班
                //获取当天当前班次组交路信息(班次)
                List<SbRouteItem> routeItems = iSbRouteItemService.listByDateAndShiftGroupId(curDate, shiftGroup.getId());
                //获取当前机队的机组信息
                List<SbStaffGroup> staffGroups = iSbStaffGroupService.list(new LambdaQueryWrapper<SbStaffGroup>().eq(SbStaffGroup::getTeamId, rotateTeam.getId()).orderByAsc(SbStaffGroup::getRotateCount));
                //每天往后移一个轮换
                int groupRotateIndex = i;
                for (SbRouteItem routeItem : routeItems) {
                    SbStaffGroup staffGroup = getRotateGroup(staffGroups, groupRotateIndex);
                    groupRotateIndex++;
                    SbStaffGroupScheduling staffGroupScheduling = new SbStaffGroupScheduling();
                    staffGroupScheduling.setDate(curDate);
                    staffGroupScheduling.setRouteItemId(routeItem.getId());
                    staffGroupScheduling.setStaffGroupId(staffGroup.getId());
                    //存储机组排班信息
                    groupSchedulingList.add(staffGroupScheduling);
                    //司机轮换是否有???
                }

            }

        }
        iSbStaffTeamSchedulingService.saveBatch(teamSchedulingList);
        iSbStaffGroupSchedulingService.saveBatch(groupSchedulingList);

    }

    private List<SbStaffTeam> sortTeams(List<SbStaffTeam> staffTeams, List<SbShiftGroup> shiftGroups, List<SbStaffTeamScheduling> yesterdayTeamScheduling) {

        if (CollectionUtils.isEmpty(yesterdayTeamScheduling)) {
            return staffTeams;
        }
        if (CollectionUtils.isEmpty(staffTeams)) {
            return staffTeams;
        }
        //获取昨天的最后一班
        SbShiftGroup lastShiftGroup = shiftGroups.get(shiftGroups.size() - 1);

        Optional<SbStaffTeamScheduling> last = yesterdayTeamScheduling.stream().filter(new Predicate<SbStaffTeamScheduling>() {
            @Override
            public boolean test(SbStaffTeamScheduling sbStaffTeamScheduling) {
                return sbStaffTeamScheduling.getShiftGroupId().equals(lastShiftGroup.getId());
            }
        }).findFirst();

        if (!last.isPresent()){
            return staffTeams;
        }

        //重新排序机队

        List<SbStaffTeam>teams = new ArrayList<>();
        int index = 0;
        boolean isFind = false;
        //循环遍历 当两个list数量一致为止

        while (teams.size() != staffTeams.size()){
                    SbStaffTeam sbStaffTeam = staffTeams.get(index % staffTeams.size());
            if (isFind){
                teams.add(sbStaffTeam);
            }
            if (sbStaffTeam.getId().equals(last.get().getStaffTeamId())){
                isFind = true;
            }

            index ++;
        }
        return teams;
    }


    private SbStaffTeam getRotateTeam(List<SbStaffTeam> staffTeams, int index) {
        if (index >= staffTeams.size()) {
            index = index % staffTeams.size();
        }
        return staffTeams.get(index);
    }


    private SbStaffGroup getRotateGroup(List<SbStaffGroup> staffGroups, int index) {
        if (index >= staffGroups.size()) {
            index = index % staffGroups.size();
        }
        log.info("index = {}", index);
        return staffGroups.get(index);
    }
}
