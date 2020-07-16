package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SnNotificationUserRel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
public interface ISnNotificationUserRelService extends IService<SnNotificationUserRel> {

    void updateRelations(Long id, List<Long> userIds);

    void removeByNotificationId(Long id);
}
