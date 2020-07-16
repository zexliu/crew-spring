package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SnAnnouncement;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SnAnnouncementReq;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
public interface ISnAnnouncementService extends IService<SnAnnouncement> {

    SnAnnouncement create(SnAnnouncementReq req);

    SnAnnouncement update(Long id, SnAnnouncementReq req);

    void delete(Long id);

}
