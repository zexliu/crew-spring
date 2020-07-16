package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbStaffTeam;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbStaffTeamReq;
import wiki.zex.cloud.example.resp.SbStaffTeamListResp;
import wiki.zex.cloud.example.resp.SbStaffTeamResp;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbStaffTeamService;

import javax.validation.Valid;

/**
 * <p>
 * 机队 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@RestController
@Api(tags = "机队管理")
@RequestMapping("/api/v1/staff/teams")
public class SbStaffTeamController {

    @Autowired
    private ISbStaffTeamService iSbStaffTeamService;

    @GetMapping
    public IPage<SbStaffTeamListResp> list(Pageable pageable, String teamName) {
            return iSbStaffTeamService.list(pageable.convert(),teamName);
    }

    @GetMapping("/{id}")
    public SbStaffTeamResp getById(@PathVariable Long id ){
        return iSbStaffTeamService.getDetails(id);
    }

    @PostMapping
    public SbStaffTeam create(@RequestBody @Valid SbStaffTeamReq req) {
        return iSbStaffTeamService.create(req);
    }

    @PutMapping("/{id}")
    public SbStaffTeam update(@PathVariable Long id, @Valid @RequestBody SbStaffTeamReq req) {
        return iSbStaffTeamService.updateById(id, req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSbStaffTeamService.delete(id);
        return SimpleResp.SUCCESS;
    }
}
