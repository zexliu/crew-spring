package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbRouteTable;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbRouteTableReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbRouteTableService;

import javax.validation.Valid;

/**
 * <p>
 * 交路计划表 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@RestController
@Api(tags = "交路计划")
@RequestMapping("/api/v1/route/tables")
public class SbRouteTableController {

    @Autowired
    private ISbRouteTableService iSbRouteTableService;

    @GetMapping
    public IPage<SbRouteTable> list(Pageable pageable) {
        return iSbRouteTableService.page(pageable.convert());
    }

    @GetMapping("/{id}")
    public SbRouteTable getById(@PathVariable Long id) {
        return iSbRouteTableService.getById(id);
    }

    @PostMapping
    public SbRouteTable create(@Valid @RequestBody SbRouteTableReq req) {
        return iSbRouteTableService.create(req);
    }

    @PutMapping("/{id}")
    public SbRouteTable update(@PathVariable Long id, @Valid @RequestBody SbRouteTableReq req) {
        return iSbRouteTableService.update(id, req);
    }


    @PutMapping("/{id}/enable")
    public SimpleResp updateEnable(@PathVariable Long id) {
         iSbRouteTableService.updateEnable(id);
        return SimpleResp.SUCCESS;
    }

    @DeleteMapping("/{id}")
    public SimpleResp update(@PathVariable Long id) {
        iSbRouteTableService.delete(id);
        return SimpleResp.SUCCESS;
    }



}
