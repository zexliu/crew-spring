package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbStaffLeave;
import wiki.zex.cloud.example.enums.LeaveStatus;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbStaffLeaveAuditReq;
import wiki.zex.cloud.example.req.SbStaffLeaveReq;
import wiki.zex.cloud.example.resp.SbStaffLeaveDetails;
import wiki.zex.cloud.example.resp.SbStaffLeaveResp;
import wiki.zex.cloud.example.service.ISbStaffLeaveService;

/**
 * <p>
 * 请假表 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
@RestController
@RequestMapping("/api/v1/leaves")
public class SbStaffLeaveController {
    @Autowired
    private ISbStaffLeaveService iSbStaffLeaveService;

    @GetMapping
    public IPage<SbStaffLeaveResp> leaves(Pageable pageable, LeaveStatus status, Integer type,Long staffId) {
        return iSbStaffLeaveService.leaves(pageable.convert(), status,type,staffId);
    }


    @GetMapping("/{id}")
    public SbStaffLeaveDetails details(@PathVariable Long id){
        return iSbStaffLeaveService.details(id);
    }


    //申请假期
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public SbStaffLeave create(@RequestBody SbStaffLeaveReq req, Authentication authentication){
        return  iSbStaffLeaveService.create(req,authentication);
    }


    //修改申请
    @PostMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public SbStaffLeave update(@PathVariable Long id , @RequestBody SbStaffLeaveReq req,Authentication authentication){
        return  iSbStaffLeaveService.update(id,req,authentication);
    }


    //审核
    @PostMapping("/audit/{id}")
    @PreAuthorize("isAuthenticated()")
    public SbStaffLeave audit(@PathVariable Long id , @RequestBody SbStaffLeaveAuditReq req, Authentication authentication){
        return  iSbStaffLeaveService.audit(id,req,authentication);
    }

}
