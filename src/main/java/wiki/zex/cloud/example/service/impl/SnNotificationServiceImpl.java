package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wiki.zex.cloud.example.entity.SnNotification;
import wiki.zex.cloud.example.enums.NotificationChannelType;
import wiki.zex.cloud.example.mapper.SnNotificationMapper;
import wiki.zex.cloud.example.req.SnNotificationReq;
import wiki.zex.cloud.example.resp.SnNotificationDetail;
import wiki.zex.cloud.example.service.ISnNotificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wiki.zex.cloud.example.service.ISnNotificationUserRelService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@Service
public class SnNotificationServiceImpl extends ServiceImpl<SnNotificationMapper, SnNotification> implements ISnNotificationService {

    @Autowired
    private ISnNotificationUserRelService iSnNotificationUserRelService;
    @Override
    public IPage<SnNotification> list(Page<SnNotification> page, NotificationChannelType channelType, String keywords, Long userId) {
        return baseMapper.list(page,channelType,keywords,userId);
    }

    @Override
    @Transactional
    public SnNotification create(SnNotificationReq req) {
        SnNotification notification = new SnNotification();
        BeanUtils.copyProperties(req,notification);
        save(notification);
        if (req.getPublishType() != 1){
            iSnNotificationUserRelService.updateRelations(notification.getId(),req.getUserIds());
        }
        return notification;
    }

    @Override
    @Transactional
    public SnNotification update(Long id, SnNotificationReq req) {
        SnNotification notification = new SnNotification();
        BeanUtils.copyProperties(req,notification);
        updateById(notification);
        notification.setId(id);
        if (req.getPublishType() != 1){
            iSnNotificationUserRelService.updateRelations(notification.getId(),req.getUserIds());
        }
        return notification;

    }

    @Override
    @Transactional
    public void delete(Long id) {
        iSnNotificationUserRelService.removeByNotificationId(id);
        removeById(id);
    }

    @Override
    public SnNotificationDetail getDetailsById(Long id) {
        return baseMapper.getDetailsById(id);
    }
}
