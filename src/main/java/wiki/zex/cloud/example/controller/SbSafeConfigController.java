package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbSafeConfig;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbSafeConfigReq;
import wiki.zex.cloud.example.resp.SbSafeConfigResp;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbSafeConfigService;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-07-20
 */
@RestController
@RequestMapping("/api/v1/safe/configs")
public class SbSafeConfigController {


    @Autowired
    private ISbSafeConfigService iSbSafeConfigService;

    @GetMapping
    public IPage<SbSafeConfigResp> list(Pageable pageable,Integer type){
        return iSbSafeConfigService.list(pageable.convert(),type);
    }

    @GetMapping("/latest")
    public SbSafeConfig latest(){
        return iSbSafeConfigService.latest();
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public SbSafeConfig create(@Valid @RequestBody SbSafeConfigReq req, Authentication authentication){
       return iSbSafeConfigService.create(req,authentication);

    }
}
