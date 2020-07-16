package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbStaff;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbStaffReq;
import wiki.zex.cloud.example.resp.SbStaffDetailsResp;
import wiki.zex.cloud.example.resp.SbStaffResp;
import wiki.zex.cloud.example.resp.SbStaffSchedulingDayResp;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface ISbStaffService extends IService<SbStaff> {

    void updateTeamLeaders(Long id, List<Long> leaderIds);

    void removeByTeamId(Long id);

    void removeByGroupId(Long id);

    IPage<SbStaffResp> list(Page<SbStaffResp> convert, String mobile, String realName, String workNo, Long teamId, Long groupId, Integer jobTitle);

    void updateGroupLeaders(Long id, List<Long> leaderIds);

    SbStaff create(SbStaffReq req);


    SbStaffDetailsResp getDetailsById(Long id);

    void delete(Long id);

    SbStaff update(Long id, SbStaffReq req);


   IPage<Map<String, String>> scheduling(Page<Map<String, String>> convert, LocalDate startAt, LocalDate endAt, Long teamId, Long groupId);


    IPage<SbStaffSchedulingDayResp>  day(Page<SbStaffSchedulingDayResp> page, LocalDate date, Long shiftGroupId, Long shiftId, String routeItemNo, Long staffTeamId, Long staffGroupId);
}
