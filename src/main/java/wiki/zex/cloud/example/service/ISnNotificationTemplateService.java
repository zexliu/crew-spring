package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SnNotificationTemplate;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SnNotificationTemplateReq;

/**
 * <p>
 * 公告模板 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
public interface ISnNotificationTemplateService extends IService<SnNotificationTemplate> {

    SnNotificationTemplate create(SnNotificationTemplateReq req);

    SnNotificationTemplate update(Long id, SnNotificationTemplateReq req);

    void delete(Long id);
}
