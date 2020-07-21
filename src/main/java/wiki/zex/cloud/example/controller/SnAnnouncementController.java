package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SnAnnouncement;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SnAnnouncementReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISnAnnouncementService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.function.Consumer;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/api/v1/announcements")
public class SnAnnouncementController {
    @Autowired
    private ISnAnnouncementService iSnAnnouncementService;
    @GetMapping
    public IPage<SnAnnouncement> list(Pageable pageable, Integer announcementType , String keywords,Boolean validStatus,Boolean validTime) {
        return iSnAnnouncementService.page(pageable.convert(),new LambdaQueryWrapper<SnAnnouncement>()
                .eq(announcementType != null, SnAnnouncement::getAnnouncementType,announcementType)
                .eq(validStatus != null,SnAnnouncement::getValidStatus,validStatus)
                .and(validTime != null, i -> i.ge(SnAnnouncement::getValidStartAt, LocalDateTime.now()).or().isNull(SnAnnouncement::getValidStartAt))
                .and(validTime != null, i -> i.le(SnAnnouncement::getValidEndAt, LocalDateTime.now()).or().isNull(SnAnnouncement::getValidEndAt))
                .like(StringUtils.isNotBlank(keywords),SnAnnouncement::getTitle,keywords));
    }

    @GetMapping("/{id}")
    public SnAnnouncement getById( @PathVariable Long id ) {
        return iSnAnnouncementService.getById(id);
    }
    @PostMapping
    public SnAnnouncement create(@RequestBody @Valid SnAnnouncementReq req) {
        return iSnAnnouncementService.create(req);
    }

    @PutMapping("/{id}")
    public SnAnnouncement update( @PathVariable Long id ,@RequestBody @Valid SnAnnouncementReq req) {
        return iSnAnnouncementService.update(id,req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSnAnnouncementService.delete(id);
        return SimpleResp.SUCCESS;
    }


}
