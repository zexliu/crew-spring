package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SbStaffDetailsResp;
import wiki.zex.cloud.example.resp.SbStaffResp;
import wiki.zex.cloud.example.resp.SbStaffSchedulingDayResp;
import wiki.zex.cloud.example.resp.SchedulingPlanResp;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface SbStaffMapper extends BaseMapper<SbStaff> {

    List<Long> selectLeaderByTeamId(@Param("teamId") Long teamId);
    List<Long> selectLeaderByGroupId(@Param("groupId") Long groupId);

    IPage<SbStaffResp> list(Page<SbStaffResp> page, @Param("mobile") String mobile,
                            @Param("realName") String realName,
                            @Param("workNo")String workNo,
                            @Param("teamId")Long teamId,
                            @Param("groupId")Long groupId,
                            @Param("jobTitle")Integer jobTitle);

    SbStaffDetailsResp getDetailsById(@Param("id") Long id);

    IPage<Map<String, String>> scheduling(Page<Map<String, String>> page,@Param("sql") String sql, @Param("startAt") LocalDate startAt, @Param("endAt") LocalDate endAt, @Param("teamId") Long teamId, @Param("groupId") Long groupId);

    IPage<SbStaffSchedulingDayResp> day(Page<SbStaffSchedulingDayResp> page,
                                        @Param("date")LocalDate date,
                                        @Param("shiftId")Long shiftId,
                                        @Param("shiftGroupId")Long shiftGroupId,
                                        @Param("routeItemNo")String routeItemNo,
                                        @Param("staffTeamId")Long staffTeamId,
                                        @Param("staffGroupId")Long staffGroupId);

    IPage<SchedulingPlanResp> led(Page<SchedulingPlanResp> page);
}
