package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.security.core.Authentication;
import wiki.zex.cloud.example.entity.SbStaffLeave;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.enums.LeaveStatus;
import wiki.zex.cloud.example.req.SbStaffLeaveAuditReq;
import wiki.zex.cloud.example.req.SbStaffLeaveReq;
import wiki.zex.cloud.example.resp.SbStaffLeaveDetails;
import wiki.zex.cloud.example.resp.SbStaffLeaveResp;

/**
 * <p>
 * 请假表 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
public interface ISbStaffLeaveService extends IService<SbStaffLeave> {

    SbStaffLeaveDetails details(Long id);

    SbStaffLeave create(SbStaffLeaveReq req, Authentication authentication);

    SbStaffLeave update(Long id, SbStaffLeaveReq req, Authentication authentication);

    IPage<SbStaffLeaveResp> leaves(Page<SbStaffLeaveResp> convert, LeaveStatus status, Integer type, Long staffId);

    SbStaffLeave audit(Long id, SbStaffLeaveAuditReq req, Authentication authentication);

}
