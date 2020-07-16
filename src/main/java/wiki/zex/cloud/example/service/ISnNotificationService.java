package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SnNotification;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.enums.NotificationChannelType;
import wiki.zex.cloud.example.req.SnNotificationReq;
import wiki.zex.cloud.example.resp.SnNotificationDetail;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
public interface ISnNotificationService extends IService<SnNotification> {

    IPage<SnNotification> list(Page<SnNotification> page, NotificationChannelType channelType, String keywords, Long userId);

    SnNotification create(SnNotificationReq req);

    SnNotification update(Long id, SnNotificationReq req);

    void delete(Long id);

    SnNotificationDetail getDetailsById(Long id);

}
