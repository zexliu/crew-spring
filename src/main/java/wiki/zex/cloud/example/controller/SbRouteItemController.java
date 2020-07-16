package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbRouteItem;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbRouteItemReq;
import wiki.zex.cloud.example.resp.SbRouteItemDetailsResp;
import wiki.zex.cloud.example.resp.SbRouteItemListResp;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbRouteItemService;

import javax.validation.Valid;

/**
 * <p>
 * 交路计划明细表 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@RestController
@Api(tags = "交路计划项")
@RequestMapping("/api/v1/route/items")
public class SbRouteItemController {

    @Autowired
    private ISbRouteItemService iSbRouteItemService;

    @GetMapping
    IPage<SbRouteItemListResp> list(Pageable pageable, Long tableId, Long shiftId, String routeItemNo,
                                    Long attendanceStationId, String meetTrainNo, Long meetStationId,
                                    String backTrainNo, Long backStationId) {
        return  iSbRouteItemService.list(pageable.convert(),tableId,shiftId,routeItemNo,attendanceStationId,meetTrainNo,meetStationId,backTrainNo,backStationId);
//        return iSbRouteItemService.page(pageable.convert(), new LambdaQueryWrapper<SbRouteItem>()
//                .eq(tableId != null, SbRouteItem::getTableId, tableId)
//                .eq(shiftId != null, SbRouteItem::getShiftId, shiftId)
//                .eq(StringUtils.isNotBlank(routeItemNo), SbRouteItem::getRouteItemNo, routeItemNo)
//                .eq(attendanceStationId != null, SbRouteItem::getAttendanceStationId, attendanceStationId)
////                .eq(StringUtils.isNotBlank(meetTrainNo), SbRouteItem::getMeetTrainNo, meetTrainNo)
//                .eq(meetStationId != null, SbRouteItem::getMeetStationId, meetStationId)
////                .eq(StringUtils.isNotBlank(backTrainNo), SbRouteItem::getBackTrainNo, backTrainNo)
//                .eq(backStationId != null, SbRouteItem::getBackStationId, backStationId));
    }

    @GetMapping("/{id}")
    public SbRouteItemDetailsResp getById(@PathVariable Long id) {
        return iSbRouteItemService.getDetails(id);
    }

    @PostMapping
    public SbRouteItem create(@Valid @RequestBody SbRouteItemReq req) {
        return iSbRouteItemService.create(req);
    }

    @PutMapping("/{id}")
    public SbRouteItem update(@PathVariable Long id, @Valid @RequestBody SbRouteItemReq req) {
        return iSbRouteItemService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSbRouteItemService.delete(id);
        return SimpleResp.SUCCESS;
    }

    @PostMapping("gen")
    public SimpleResp generate(){
        return  SimpleResp.SUCCESS;
    }
}
