package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SnNotificationTemplate;
import wiki.zex.cloud.example.enums.NotificationChannelType;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SnNotificationTemplateReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISnNotificationTemplateService;

import javax.validation.Valid;

/**
 * <p>
 * 公告模板 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/api/v1/notification/templates")
public class SnNotificationTemplateController {

    @Autowired
    private ISnNotificationTemplateService iSnNotificationTemplateService;
    @GetMapping
    public IPage<SnNotificationTemplate> list(Pageable pageable, NotificationChannelType channelType , String keywords) {
        return iSnNotificationTemplateService.page(pageable.convert(),new LambdaQueryWrapper<SnNotificationTemplate>().eq(channelType != null, SnNotificationTemplate::getChannelType,channelType)
                .like(StringUtils.isNotBlank(keywords),SnNotificationTemplate::getTemplateTitle,keywords));
    }

    @GetMapping("/{id}")
    public SnNotificationTemplate getById( @PathVariable Long id ) {
        return iSnNotificationTemplateService.getById(id);
    }
    @PostMapping
    public SnNotificationTemplate create(@RequestBody @Valid SnNotificationTemplateReq req) {
        return iSnNotificationTemplateService.create(req);
    }

    @PutMapping("/{id}")
    public SnNotificationTemplate update( @PathVariable Long id ,@RequestBody @Valid SnNotificationTemplateReq req) {
        return iSnNotificationTemplateService.update(id,req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
         iSnNotificationTemplateService.delete(id);
         return SimpleResp.SUCCESS;
    }









}
