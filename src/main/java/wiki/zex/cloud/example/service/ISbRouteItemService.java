package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SbRouteItem;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbRouteItemReq;

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

    SbRouteItem getDetails(Long id);

}
