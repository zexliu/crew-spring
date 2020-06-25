package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbRouteItem;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbRouteItemReq;
import wiki.zex.cloud.example.resp.SbRouteItemDetailsResp;
import wiki.zex.cloud.example.resp.SbRouteItemListResp;

/**
 * <p>
 * 交路计划明细表 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
public interface ISbRouteItemService extends IService<SbRouteItem> {

    void removeByTableId(Long id);

    SbRouteItem create(SbRouteItemReq req);

    SbRouteItem update(Long id, SbRouteItemReq req);

    void delete(Long id);

    SbRouteItemDetailsResp getDetails(Long id);

   IPage<SbRouteItemListResp> list(Page<SbRouteItemListResp> page, Long tableId, Long shiftId, String routeItemNo, Long attendanceStationId, String meetTrainNo, Long meetStationId, String backTrainNo, Long backStationId);
}
