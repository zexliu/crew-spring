package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbStaffGroup;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbStaffGroupReq;
import wiki.zex.cloud.example.resp.SbStaffGroupListResp;
import wiki.zex.cloud.example.resp.SbStaffGroupResp;
import wiki.zex.cloud.example.resp.SbStaffTeamResp;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbStaffGroupService;

import javax.validation.Valid;

/**
 * <p>
 * 机队组 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@RestController
@Api(tags = "机组管理")
@RequestMapping("/api/v1/staff/groups")
public class SbStaffGroupController {
    @Autowired
    private ISbStaffGroupService iSbStaffGroupService;

    @GetMapping
    public IPage<SbStaffGroupListResp> list(Pageable pageable, Long teamId, String groupName) {
      return  iSbStaffGroupService.page(pageable.convert(),teamId,groupName);
    }

    @PostMapping
    public SbStaffGroup create(@RequestBody @Valid SbStaffGroupReq req) {
        return iSbStaffGroupService.create(req);
    }

    @PutMapping("/{id}")
    public SbStaffGroup update(@PathVariable Long id, @Valid @RequestBody SbStaffGroupReq req) {
        return iSbStaffGroupService.updateById(id, req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSbStaffGroupService.delete(id);
        return SimpleResp.SUCCESS;
    }


    @GetMapping("/{id}")
    public SbStaffGroupResp getById(@PathVariable Long id ){
        return iSbStaffGroupService.getDetails(id);
    }

}
