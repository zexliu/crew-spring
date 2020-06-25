package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import wiki.zex.cloud.example.entity.SbRouteRuntimeRelation;
import wiki.zex.cloud.example.mapper.SbRouteRuntimeRelationMapper;
import wiki.zex.cloud.example.service.ISbRouteRuntimeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 交路明细时刻明细关联关系 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Service
public class SbRouteRuntimeRelationServiceImpl extends ServiceImpl<SbRouteRuntimeRelationMapper, SbRouteRuntimeRelation> implements ISbRouteRuntimeRelationService {

    @Override
    public void updateRelations(Long id, List<Long> runtimeItemIds) {
        removeByRouteItemId(id);
        if (CollectionUtils.isNotEmpty(runtimeItemIds)) {
            List<SbRouteRuntimeRelation> collect = runtimeItemIds.stream().map(aLong -> {
                SbRouteRuntimeRelation relation = new SbRouteRuntimeRelation();
                relation.setRouteItemId(id);
                relation.setRuntimeItemId(aLong);
                return relation;
            }).collect(Collectors.toList());
            saveBatch(collect);
        }

    }

    @Override
    public void removeByRouteItemId(Long id) {
        remove(new LambdaQueryWrapper<SbRouteRuntimeRelation>()
                .eq(SbRouteRuntimeRelation::getRouteItemId, id));
    }
}
