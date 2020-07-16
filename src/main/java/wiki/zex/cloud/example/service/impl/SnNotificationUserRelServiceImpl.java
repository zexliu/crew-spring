package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import wiki.zex.cloud.example.entity.SnNotification;
import wiki.zex.cloud.example.entity.SnNotificationUserRel;
import wiki.zex.cloud.example.mapper.SnNotificationUserRelMapper;
import wiki.zex.cloud.example.service.ISnNotificationUserRelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@Service
public class SnNotificationUserRelServiceImpl extends ServiceImpl<SnNotificationUserRelMapper, SnNotificationUserRel> implements ISnNotificationUserRelService {

    @Override
    public void updateRelations(Long id, List<Long> userIds) {
        removeByNotificationId(id);
        if (CollectionUtils.isEmpty(userIds)){
            return;
        }
        List<SnNotificationUserRel> collect = userIds.stream().map(aLong -> {
            SnNotificationUserRel rel = new SnNotificationUserRel();
            rel.setNotificationId(id);
            rel.setUserId(aLong);
            return rel;
        }).collect(Collectors.toList());

        saveBatch(collect);
    }

    @Override
    public void removeByNotificationId(Long id) {
        remove(new LambdaQueryWrapper<SnNotificationUserRel>().eq(SnNotificationUserRel::getNotificationId,id));

    }
}
