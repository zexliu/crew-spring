package wiki.zex.cloud.example.service.impl;

import org.springframework.beans.BeanUtils;
import wiki.zex.cloud.example.entity.SnAnnouncement;
import wiki.zex.cloud.example.mapper.SnAnnouncementMapper;
import wiki.zex.cloud.example.req.SnAnnouncementReq;
import wiki.zex.cloud.example.service.ISnAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@Service
public class SnAnnouncementServiceImpl extends ServiceImpl<SnAnnouncementMapper, SnAnnouncement> implements ISnAnnouncementService {

    @Override
    public SnAnnouncement create(SnAnnouncementReq req) {
        SnAnnouncement snAnnouncement = new SnAnnouncement();
        BeanUtils.copyProperties(req,snAnnouncement);
        save(snAnnouncement);
        return snAnnouncement;
    }

    @Override
    public SnAnnouncement update(Long id, SnAnnouncementReq req) {
        SnAnnouncement snAnnouncement = new SnAnnouncement();
        BeanUtils.copyProperties(req,snAnnouncement);
        snAnnouncement.setId(id);
        updateById(snAnnouncement);
        return snAnnouncement;
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }


}
