package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SbRouteRuntimeRel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 交路明细时刻明细关联关系 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
public interface ISbRouteRuntimeRelService extends IService<SbRouteRuntimeRel> {

    void updateRelations(Long id, List<Long> runtimeItemIds);

    void removeByRouteItemId(Long id);

}
