package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import wiki.zex.cloud.example.entity.SbStaffLeave;
import wiki.zex.cloud.example.entity.SbStaffLeaveLog;
import wiki.zex.cloud.example.enums.LeaveLogType;
import wiki.zex.cloud.example.enums.LeaveStatus;
import wiki.zex.cloud.example.exception.ForbiddenException;
import wiki.zex.cloud.example.exception.NotFoundException;
import wiki.zex.cloud.example.mapper.SbStaffLeaveMapper;
import wiki.zex.cloud.example.req.SbStaffLeaveAuditReq;
import wiki.zex.cloud.example.req.SbStaffLeaveReq;
import wiki.zex.cloud.example.resp.SbStaffLeaveDetails;
import wiki.zex.cloud.example.resp.SbStaffLeaveResp;
import wiki.zex.cloud.example.security.MyUserDetails;
import wiki.zex.cloud.example.service.ISbStaffLeaveLogService;
import wiki.zex.cloud.example.service.ISbStaffLeaveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 请假表 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
@Service
public class SbStaffLeaveServiceImpl extends ServiceImpl<SbStaffLeaveMapper, SbStaffLeave> implements ISbStaffLeaveService {

    @Autowired
    private ISbStaffLeaveLogService iSbStaffLeaveLogService;

    @Override
    public SbStaffLeaveDetails details(Long id) {
        return baseMapper.details(id);
    }

    @Override
    @Transactional
    public SbStaffLeave create(SbStaffLeaveReq req, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        SbStaffLeave sbStaffLeave = new SbStaffLeave();
        BeanUtils.copyProperties(req, sbStaffLeave);
        sbStaffLeave.setUserId(myUserDetails.getId());
        sbStaffLeave.setStatus(LeaveStatus.PENDING);
        sbStaffLeave.setDays((int) (sbStaffLeave.getBackAt().toEpochDay() - sbStaffLeave.getLeaveAt().toEpochDay()));
        save(sbStaffLeave);
        SbStaffLeaveLog log = new SbStaffLeaveLog();
        log.setLeaveId(sbStaffLeave.getId());
        log.setDescription(sbStaffLeave.getDescription());
        log.setOperatorId(myUserDetails.getId());
        log.setType(LeaveLogType.CREATE);
        iSbStaffLeaveLogService.save(log);
        return sbStaffLeave;
    }

    @Override
    @Transactional
    public SbStaffLeave update(Long id, SbStaffLeaveReq req, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        SbStaffLeave sbStaffLeave = getById(id);
        if (sbStaffLeave == null) {
            throw new NotFoundException();
        }
        if (!sbStaffLeave.getUserId().equals(myUserDetails.getId())) {
            throw new ForbiddenException();
        }
        BeanUtils.copyProperties(req, sbStaffLeave);
        sbStaffLeave.setStatus(LeaveStatus.PENDING);
        sbStaffLeave.setDays((int) (sbStaffLeave.getBackAt().toEpochDay() - sbStaffLeave.getLeaveAt().toEpochDay()));
        updateById(sbStaffLeave);

        SbStaffLeaveLog log = new SbStaffLeaveLog();
        log.setLeaveId(sbStaffLeave.getId());
        log.setDescription(sbStaffLeave.getDescription());
        log.setOperatorId(myUserDetails.getId());
        log.setType(LeaveLogType.UPDATE);
        iSbStaffLeaveLogService.save(log);
        return sbStaffLeave;
    }


    @Override
    public IPage<SbStaffLeaveResp> leaves(Page<SbStaffLeaveResp> page, LeaveStatus status, Integer type, Long staffId) {
        return baseMapper.leaves(page, status, type, staffId);
    }

    @Override
    @Transactional
    public SbStaffLeave audit(Long id, SbStaffLeaveAuditReq req, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        SbStaffLeave leave = getById(id);
        if (leave.getStatus() != LeaveStatus.PENDING){
            throw new ForbiddenException();
        }
        leave.setStatus(req.getIsPass() ? LeaveStatus.PASSED:LeaveStatus.REJECTED);
        updateById(leave);
        SbStaffLeaveLog log = new SbStaffLeaveLog();
        log.setLeaveId(id);
        log.setDescription(req.getDescription());
        log.setOperatorId(myUserDetails.getId());
        log.setType(req.getIsPass()? LeaveLogType.PASS:LeaveLogType.REJECT);
        iSbStaffLeaveLogService.save(log);
        return leave;
    }
}
