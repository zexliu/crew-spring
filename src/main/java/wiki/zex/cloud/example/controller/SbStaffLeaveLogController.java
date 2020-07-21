package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.resp.SbStaffLeaveLogResp;
import wiki.zex.cloud.example.service.ISbStaffLeaveLogService;

/**
 * <p>
 * 请假审核记录 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
@RestController
@RequestMapping("/api/v1/leave/logs")
public class SbStaffLeaveLogController {

    @Autowired
    private ISbStaffLeaveLogService iSbStaffLeaveLogService;
    @GetMapping
    public IPage<SbStaffLeaveLogResp> list(Pageable pageable){
        return iSbStaffLeaveLogService.mPage(pageable.convert());
    }

}
