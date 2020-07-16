package wiki.zex.cloud.example.service.impl;

import org.springframework.beans.BeanUtils;
import wiki.zex.cloud.example.entity.SnNotificationTemplate;
import wiki.zex.cloud.example.mapper.SnNotificationTemplateMapper;
import wiki.zex.cloud.example.req.SnNotificationTemplateReq;
import wiki.zex.cloud.example.service.ISnNotificationTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告模板 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@Service
public class SnNotificationTemplateServiceImpl extends ServiceImpl<SnNotificationTemplateMapper, SnNotificationTemplate> implements ISnNotificationTemplateService {

    @Override
    public SnNotificationTemplate create(SnNotificationTemplateReq req) {
        SnNotificationTemplate template = new SnNotificationTemplate();
        BeanUtils.copyProperties(req,template);
        save(template);
        return template;
    }

    @Override
    public SnNotificationTemplate update(Long id, SnNotificationTemplateReq req) {

        SnNotificationTemplate template = new SnNotificationTemplate();
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
