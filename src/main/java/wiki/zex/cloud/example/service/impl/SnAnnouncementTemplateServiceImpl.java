package wiki.zex.cloud.example.service.impl;

import org.springframework.beans.BeanUtils;
import wiki.zex.cloud.example.entity.SnAnnouncementTemplate;
import wiki.zex.cloud.example.mapper.SnAnnouncementTemplateMapper;
import wiki.zex.cloud.example.req.SnAnnouncementTemplateReq;
import wiki.zex.cloud.example.service.ISnAnnouncementTemplateService;
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
public class SnAnnouncementTemplateServiceImpl extends ServiceImpl<SnAnnouncementTemplateMapper, SnAnnouncementTemplate> implements ISnAnnouncementTemplateService {

    @Override
    public SnAnnouncementTemplate create(SnAnnouncementTemplateReq req) {
        SnAnnouncementTemplate template = new SnAnnouncementTemplate();
        BeanUtils.copyProperties(req,template);
        save(template);
        return template;
    }

    @Override
    public SnAnnouncementTemplate update(Long id, SnAnnouncementTemplateReq req) {
        SnAnnouncementTemplate template = new SnAnnouncementTemplate();
        BeanUtils.copyProperties(req,template);
        template.setId(id);
        updateById(template);
        return template;
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }
}
