package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SnAnnouncementTemplate;
import wiki.zex.cloud.example.enums.NotificationChannelType;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SnAnnouncementTemplateReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISnAnnouncementTemplateService;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/api/v1/announcement/templates")
public class SnAnnouncementTemplateController {
    @Autowired
    private ISnAnnouncementTemplateService iSnAnnouncementTemplateService;
    @GetMapping
    public IPage<SnAnnouncementTemplate> list(Pageable pageable, Integer announcementType , String keywords) {
        return iSnAnnouncementTemplateService.page(pageable.convert(),new LambdaQueryWrapper<SnAnnouncementTemplate>()
                .eq(announcementType != null, SnAnnouncementTemplate::getAnnouncementType,announcementType)
                .like(StringUtils.isNotBlank(keywords),SnAnnouncementTemplate::getTemplateTitle,keywords));
    }

    @GetMapping("/{id}")
    public SnAnnouncementTemplate getById( @PathVariable Long id ) {
        return iSnAnnouncementTemplateService.getById(id);
    }
    @PostMapping
    public SnAnnouncementTemplate create(@RequestBody @Valid SnAnnouncementTemplateReq req) {
        return iSnAnnouncementTemplateService.create(req);
    }

    @PutMapping("/{id}")
    public SnAnnouncementTemplate update( @PathVariable Long id ,@RequestBody @Valid SnAnnouncementTemplateReq req) {
        return iSnAnnouncementTemplateService.update(id,req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSnAnnouncementTemplateService.delete(id);
        return SimpleResp.SUCCESS;
    }
    
    
    
}
