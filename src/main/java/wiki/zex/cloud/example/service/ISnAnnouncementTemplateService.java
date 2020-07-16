package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SnAnnouncementTemplate;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SnAnnouncementTemplateReq;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
public interface ISnAnnouncementTemplateService extends IService<SnAnnouncementTemplate> {

    SnAnnouncementTemplate create(SnAnnouncementTemplateReq req);

    SnAnnouncementTemplate update(Long id, SnAnnouncementTemplateReq req);

    void delete(Long id);

}
