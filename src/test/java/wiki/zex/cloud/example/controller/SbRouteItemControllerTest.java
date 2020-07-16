package wiki.zex.cloud.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.util.ApplicationContextTestUtils;
import wiki.zex.cloud.example.ExampleApplicationTests;
import wiki.zex.cloud.example.entity.*;
import wiki.zex.cloud.example.req.SbStaffReq;
import wiki.zex.cloud.example.service.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class SbRouteItemControllerTest extends ExampleApplicationTests {

//    @Autowired
//    private ISbRuntimeItemService iSbRuntimeItemService;

    @Autowired
    private ISbStaffTeamService iSbStaffTeamService;

    @Autowired
    private ISbStaffGroupService iSbStaffGroupService;

    @Autowired
    private ISyDictEntryService iSyDictEntryService;

    @Autowired
    private ISbStaffService iSbStaffService;

//
//    @Test
//    void generate() {
//
//        List<SbStaffGroup> groups = new ArrayList<>();
//        List<SbStaffTeam> list = iSbStaffTeamService.list();
//        for (SbStaffTeam sbStaffTeam : list) {
//
//            for (int i = 1; i <= 50; i++) {
//                SbStaffGroup group = new SbStaffGroup();
//                group.setGroupName(sbStaffTeam.getTeamName().replace("队", "") + i + "组");
//                group.setRotateCount(0);
//                group.setTeamId(sbStaffTeam.getId());
//                groups.add(group);
//            }
//        }
//        iSbStaffGroupService.saveBatch(groups);
//
//    }

//
    @Test
    void generate() {
        int workNo = 1000;

        List<SyDictEntry> job_title = iSyDictEntryService.list(new LambdaQueryWrapper<SyDictEntry>().eq(SyDictEntry::getDictCode, "JOB_TITLE"));

        List<SbStaffGroup> list = iSbStaffGroupService.list();

        for (SbStaffGroup group : list) {
            for (SyDictEntry syDictEntry : job_title) {
                SbStaffReq req = new SbStaffReq();
                req.setGroupId(group.getId());
                req.setJobTitle(Integer.valueOf(syDictEntry.getDictEntryValue()));
                req.setRealName(group.getGroupName() + syDictEntry.getDictEntryName());
                req.setTeamId(group.getTeamId());
                req.setWorkNo(String.valueOf(workNo));
                req.setMobile("1871388" + workNo);
                workNo++;
                iSbStaffService.create(req);
            }

        }
    }

//        int runCount = 3; //运转方式
//
//        //早班时间
//        LocalTime moneyWorkStart = LocalTime.of(5, 0);
//        LocalTime moneyWorkEnd = LocalTime.of(10, 0);
//
//        //白班时间
//        LocalTime dayWorkStart = LocalTime.of(11, 0);
//        LocalTime dayWorkEnd = LocalTime.of(18, 0);
//
//        //晚班时间
//        LocalTime nightWorkStart = LocalTime.of(18, 0);
//        LocalTime nightWorkEnd = LocalTime.of(23, 0);
//
//        //早/中交接班时间
//
//        //中/晚交接班时间
//
//        //连续驾驶时间标准
//        Integer continueMinutes = 60 * 4; //4小时
//        //休息时间标准
//        Integer restMinutes = 20; //20分钟
//
//        //上下班地点
//
//        //轮换地点
//
//        //车辆段出勤提前
//
//        Integer beforeStartMinutes = 20;
//
//        Integer AfterEndMinutes = 20;
//        //便乘提前
//        Integer beforeTakeMinutes = 20;
//
//        List<SbRuntimeItem> runtimeItems = iSbRuntimeItemService.list();



}