package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbShiftGroup;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbShiftGroupReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbShiftGroupService;

import javax.validation.Valid;

/**
 * <p>
 * 班次所属 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/api/v1/shift/groups")
@Api(tags = "班次组")
public class SbShiftGroupController {

    @Autowired
    private ISbShiftGroupService iSbShiftGroupService;

    @GetMapping
    public IPage<SbShiftGroup> list(Pageable pageable) {
        return iSbShiftGroupService.page(pageable.convert(),new LambdaQueryWrapper<SbShiftGroup>().orderByDesc(SbShiftGroup::getSeq));
    }


    @GetMapping("/{id}")
    public SbShiftGroup getById(@PathVariable Long id) {
        return iSbShiftGroupService.getById(id);
    }


    @PostMapping
    public SbShiftGroup create(@RequestBody @Valid SbShiftGroupReq req) {
        return iSbShiftGroupService.create(req);
    }


    @PutMapping("/{id}")
    public SbShiftGroup update(@PathVariable Long id, @RequestBody @Valid SbShiftGroupReq req) {
        return iSbShiftGroupService.update(id, req);
    }


    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSbShiftGroupService.delete(id);
        return SimpleResp.SUCCESS;
    }

}
