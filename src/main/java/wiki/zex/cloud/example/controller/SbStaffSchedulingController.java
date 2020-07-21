package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.StaffSchedulingReq;
import wiki.zex.cloud.example.resp.SbStaffSchedulingDayResp;
import wiki.zex.cloud.example.resp.SchedulingPlanResp;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbStaffSchedulingService;
import wiki.zex.cloud.example.service.ISbStaffService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@RequestMapping("/api/v1/scheduling")
@Api(tags = "排班管理")
@RestController
public class SbStaffSchedulingController {

    @Autowired
    private ISbStaffSchedulingService iSbStaffSchedulingService;

    @Autowired
    private ISbStaffService iSbStaffService;

    @PostMapping("/gen")
    public SimpleResp generate(@Valid @RequestBody StaffSchedulingReq req) {
        iSbStaffSchedulingService.generate(req);
        return SimpleResp.SUCCESS;
    }

    @GetMapping("/staff")
    public IPage<Map<String, String>> table(Pageable pageable, @RequestParam LocalDate startAt, @RequestParam LocalDate endAt, Long teamId, Long groupId) {
        return iSbStaffService.scheduling(pageable.convert(), startAt, endAt, teamId, groupId);
    }

    @GetMapping("/day")
    public IPage<SbStaffSchedulingDayResp> day(Pageable pageable, @RequestParam LocalDate date, Long shiftId,
                                               Long shiftGroupId,
                                               String routeItemNo,
                                               Long staffTeamId,
                                               Long staffGroupId) {
//        return iSbStaffService.scheduling(pageable.convert(),date);
        return iSbStaffService.day( pageable.convert(), date, shiftGroupId, shiftId,routeItemNo,staffTeamId,staffGroupId);
    }

    @GetMapping("/led")
    public IPage<SchedulingPlanResp> led(Pageable pageable) {
        return iSbStaffService.led(pageable.convert());
    }



}
