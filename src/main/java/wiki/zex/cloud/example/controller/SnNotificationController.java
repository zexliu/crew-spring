package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SnNotification;
import wiki.zex.cloud.example.enums.NotificationChannelType;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SnNotificationReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.resp.SnNotificationDetail;
import wiki.zex.cloud.example.service.ISnNotificationService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/api/v1/notifications")
public class SnNotificationController {
    @Autowired
    private ISnNotificationService iSnNotificationService;
    @GetMapping
    public IPage<SnNotification> list(Pageable pageable, NotificationChannelType channelType , String keywords, Long userId){
        return iSnNotificationService.list(pageable.convert(),channelType,keywords,userId);
    }

    @GetMapping("/{id}")
    public SnNotificationDetail getById(@PathVariable Long id ) {
        return iSnNotificationService.getDetailsById(id);
    }
    @PostMapping
    public SnNotification create(@RequestBody @Valid SnNotificationReq req) {
        return iSnNotificationService.create(req);
    }

    @PutMapping("/{id}")
    public SnNotification update( @PathVariable Long id ,@RequestBody @Valid SnNotificationReq req) {
        return iSnNotificationService.update(id,req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSnNotificationService.delete(id);
        return SimpleResp.SUCCESS;
    }

}
