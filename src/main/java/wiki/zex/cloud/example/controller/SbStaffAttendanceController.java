package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import wiki.zex.cloud.example.entity.SbStaffAttendance;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.resp.SbStaffAttendanceResp;
import wiki.zex.cloud.example.service.ISbStaffAttendanceService;

import java.time.LocalDate;

/**
 * <p>
 * 出勤记录 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-13
 */
@RestController
@RequestMapping("/api/v1/staff/attendances")
public class SbStaffAttendanceController {

    @Autowired
    private ISbStaffAttendanceService iSbStaffAttendanceService;

    @GetMapping
    public IPage<SbStaffAttendanceResp> list(Pageable pageable, Long staffId, Integer alcoholResult , Integer attendanceStatus, Integer backStatus , Integer answerStatus , LocalDate date) {
        return iSbStaffAttendanceService.list(pageable.convert(),staffId,alcoholResult,attendanceStatus,backStatus,answerStatus,date);
    }


}
