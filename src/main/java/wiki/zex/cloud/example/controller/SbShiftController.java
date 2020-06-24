package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbShift;
import wiki.zex.cloud.example.entity.SbShiftGroup;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbShiftReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbShiftService;

import javax.validation.Valid;

/**
 * <p>
 * 班次 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@RestController
@Api(tags = "班次管理")
@RequestMapping("/api/v1/shifts")
public class SbShiftController {

    @Autowired
    private ISbShiftService iSbShiftService;

    @GetMapping
    public IPage<SbShift> list(Pageable pageable,Long shiftGroupId) {
        return iSbShiftService.page(pageable.convert(),new LambdaQueryWrapper<SbShift>()
                .eq(shiftGroupId != null,SbShift::getShiftGroupId,shiftGroupId)
                .orderByDesc(SbShift::getSeq).orderByAsc(SbShift::getId));
    }

    @PostMapping
    public SbShift create(@RequestBody @Valid SbShiftReq req) {
        return iSbShiftService.create(req);
    }

    @GetMapping("/{id}")
    public SbShift getById(@PathVariable Long id) {
        return iSbShiftService.getById(id);
    }

    @PutMapping("/{id}")
    public SbShift update(@PathVariable Long id, @RequestBody @Valid SbShiftReq req) {
        return iSbShiftService.update(id, req);
    }


    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSbShiftService.delete(id);
        return SimpleResp.SUCCESS;
    }
}
