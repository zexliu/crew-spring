package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbStaffAttendance;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.resp.SbStaffAttendanceResp;

import java.time.LocalDate;

/**
 * <p>
 * 出勤记录 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-13
 */
public interface ISbStaffAttendanceService extends IService<SbStaffAttendance> {

    IPage<SbStaffAttendanceResp> list(Page<SbStaffAttendanceResp> page, Long staffId, Integer alcoholResult, Integer attendanceStatus, Integer backStatus, Integer answerStatus, LocalDate date);

    IPage<SbStaffAttendanceResp> led(Page<SbStaffAttendanceResp> page);
}
