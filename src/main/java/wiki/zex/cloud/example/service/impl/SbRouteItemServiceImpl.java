package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import wiki.zex.cloud.example.entity.SbRouteItem;
import wiki.zex.cloud.example.mapper.SbRouteItemMapper;
import wiki.zex.cloud.example.req.SbRouteItemReq;
import wiki.zex.cloud.example.service.ISbRouteItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public void removeByTableId(Long id) {
        remove(new LambdaQueryWrapper<SbRouteItem>().eq(SbRouteItem::getTableId,id));

    }

    @Override
    public SbRouteItem create(SbRouteItemReq req) {
        SbRouteItem item = new SbRouteItem();
        BeanUtils.copyProperties(req,item);
        save(item);
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
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public SbRouteItem getDetails(Long id) {
        return getById(id);
    }
}
