package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wiki.zex.cloud.example.entity.SbStaff;
import wiki.zex.cloud.example.entity.SyUser;
import wiki.zex.cloud.example.mapper.SbStaffMapper;
import wiki.zex.cloud.example.req.SbStaffReq;
import wiki.zex.cloud.example.req.SyUserReq;
import wiki.zex.cloud.example.resp.SbStaffDetailsResp;
import wiki.zex.cloud.example.resp.SbStaffResp;
import wiki.zex.cloud.example.resp.SbStaffSchedulingDayResp;
import wiki.zex.cloud.example.resp.SchedulingPlanResp;
import wiki.zex.cloud.example.service.ISbStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wiki.zex.cloud.example.service.ISyUserService;
import wiki.zex.cloud.example.service.ISysExtensionInfoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static wiki.zex.cloud.example.config.ConverterConfig.DEFAULT_DATE_FORMAT;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Service
public class SbStaffServiceImpl extends ServiceImpl<SbStaffMapper, SbStaff> implements ISbStaffService {

    @Autowired
    private ISyUserService iSyUserService;


    @Autowired
    private ISysExtensionInfoService iSysExtensionInfoService;
    @Override
    public void updateGroupLeaders(Long id, List<Long> leaderIds) {
        update(new LambdaUpdateWrapper<SbStaff>().set(SbStaff::getIsGroupLeader, false)
                .eq(SbStaff::getGroupId, id));
        if (CollectionUtils.isNotEmpty(leaderIds)) {
            update(new LambdaUpdateWrapper<SbStaff>().set(SbStaff::getIsGroupLeader, true)
                    .eq(SbStaff::getGroupId, id).in(SbStaff::getId, leaderIds));

        }
    }

    @Override
    @Transactional
    public SbStaff create(SbStaffReq req) {
        SyUserReq userReq = new SyUserReq();
        userReq.setUsername(req.getMobile());
        userReq.setMobile(req.getMobile());
        userReq.setAvatar(req.getAvatar());
        userReq.setBirthDay(req.getBirthDay());
        userReq.setEmail(req.getEmail());
        userReq.setGender(req.getGender());
        userReq.setPassword(DigestUtils.md5Hex(req.getMobile().substring(req.getMobile().length() - 6)));
        userReq.setRealName(req.getRealName());
        userReq.setNickname(req.getRealName());
        userReq.setWorkNo(req.getWorkNo());
        SyUser syUser = iSyUserService.create(userReq);
        SbStaff sbStaff = new SbStaff();
        BeanUtils.copyProperties(req,sbStaff);
        sbStaff.setUserId(syUser.getId());
        save(sbStaff);
        iSysExtensionInfoService.saveExtensions(sbStaff.getId(),req.getExtensions());
        return sbStaff;
    }

    @Override
    public SbStaffDetailsResp getDetailsById(Long id) {
        return baseMapper.getDetailsById(id);
    }

    @Override
    public void delete(Long id) {
        iSysExtensionInfoService.removeByInstanceId(id);
        removeById(id);
    }

    @Override
    public SbStaff update(Long id, SbStaffReq req) {
        SbStaff sbStaff = getById(id);
        SyUserReq userReq = new SyUserReq();
        userReq.setUsername(req.getMobile());
        userReq.setMobile(req.getMobile());
        userReq.setAvatar(req.getAvatar());
        userReq.setBirthDay(req.getBirthDay());
        userReq.setEmail(req.getEmail());
        userReq.setGender(req.getGender());
        userReq.setRealName(req.getRealName());
        userReq.setNickname(req.getRealName());
        userReq.setWorkNo(req.getWorkNo());
        SyUser syUser = iSyUserService.update(sbStaff.getUserId(),userReq);
        BeanUtils.copyProperties(req,sbStaff);
        sbStaff.setUserId(syUser.getId());
        updateById(sbStaff);
        iSysExtensionInfoService.saveExtensions(sbStaff.getId(),req.getExtensions());
        return sbStaff;
    }

    @Override
    public IPage<Map<String, String>> scheduling(Page<Map<String, String>> page, LocalDate startAt, LocalDate endAt, Long teamId, Long groupId) {
        long difDays = endAt.toEpochDay() - startAt.toEpochDay();

        //动态sql  放弃存储过程
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= difDays; i++) {
            String date = startAt.plusDays(i).format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
            builder.append("MAX(CASE ssgs.date WHEN '" ).append(date)
                    .append("' THEN sri.route_item_no ELSE '休' END) '").append(date).append("'");
            if (i != difDays){
                builder.append(",");
            }
        }
        return baseMapper.scheduling(page, builder.toString(), startAt, endAt, teamId, groupId);
    }

    @Override
    public IPage<SbStaffSchedulingDayResp> day(Page<SbStaffSchedulingDayResp> page, LocalDate date, Long shiftGroupId, Long shiftId, String routeItemNo, Long staffTeamId, Long staffGroupId) {
        return baseMapper.day(page,date,shiftId, shiftGroupId, routeItemNo, staffTeamId, staffGroupId);
    }

    @Override
    public IPage<SchedulingPlanResp> led(Page<SchedulingPlanResp> page) {
        return baseMapper.led(page);
    }


    @Override
    public void updateTeamLeaders(Long id, List<Long> leaderIds) {

        update(new LambdaUpdateWrapper<SbStaff>().set(SbStaff::getIsTeamLeader, false)
                .eq(SbStaff::getTeamId, id));
        if (CollectionUtils.isNotEmpty(leaderIds)) {
            update(new LambdaUpdateWrapper<SbStaff>().set(SbStaff::getIsTeamLeader, true)
                    .eq(SbStaff::getTeamId, id).in(SbStaff::getId, leaderIds));

        }

    }

    @Override
    public void removeByTeamId(Long id) {
        remove(new LambdaUpdateWrapper<SbStaff>().eq(SbStaff::getTeamId,id));
    }

    @Override
    public void removeByGroupId(Long id) {
        remove(new LambdaUpdateWrapper<SbStaff>().eq(SbStaff::getGroupId,id));
    }

    @Override
    public IPage<SbStaffResp> list(Page<SbStaffResp> page, String mobile, String realName, String workNo, Long teamId, Long groupId, Integer jobTitle) {
        return baseMapper.list(page,mobile,realName,workNo,teamId,groupId,jobTitle);
    }

}
