package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wiki.zex.cloud.example.entity.SbRouteItem;
import wiki.zex.cloud.example.mapper.SbRouteItemMapper;
import wiki.zex.cloud.example.req.SbRouteItemReq;
import wiki.zex.cloud.example.resp.SbRouteItemDetailsResp;
import wiki.zex.cloud.example.resp.SbRouteItemListResp;
import wiki.zex.cloud.example.service.ISbRouteItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wiki.zex.cloud.example.service.ISbRouteRuntimeRelationService;

/**
 * <p>
 * 交路计划明细表 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Service
public class SbRouteItemServiceImpl extends ServiceImpl<SbRouteItemMapper, SbRouteItem> implements ISbRouteItemService {

    @Autowired
    private ISbRouteRuntimeRelationService iSbRouteRuntimeRelationService;
    @Override
    public void removeByTableId(Long id) {
        remove(new LambdaQueryWrapper<SbRouteItem>().eq(SbRouteItem::getTableId,id));

    }

    @Override
    public SbRouteItem create(SbRouteItemReq req) {
        SbRouteItem item = new SbRouteItem();
        BeanUtils.copyProperties(req,item);
        save(item);
        iSbRouteRuntimeRelationService.updateRelations(item.getId(),req.getRuntimeItemIds());
        return item;
    }

    @Override
    public SbRouteItem update(Long id, SbRouteItemReq req) {
        SbRouteItem item = new SbRouteItem();
        BeanUtils.copyProperties(req,item);
        item.setId(id);
        updateById(item);
        return item;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iSbRouteRuntimeRelationService.removeByRouteItemId(id);
        removeById(id);
    }

    @Override
    public SbRouteItemDetailsResp getDetails(Long id) {
        return baseMapper.getDetails(id);
    }

    @Override
    public IPage<SbRouteItemListResp> list(Page<SbRouteItemListResp> page, Long tableId, Long shiftId, String routeItemNo, Long attendanceStationId, String meetTrainNo, Long meetStationId, String backTrainNo, Long backStationId) {
        return baseMapper.page(page,tableId,shiftId,routeItemNo,attendanceStationId,meetTrainNo,meetStationId,backTrainNo,backStationId);
    }
}
