package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.security.core.Authentication;
import wiki.zex.cloud.example.entity.SbSafeConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbSafeConfigReq;
import wiki.zex.cloud.example.resp.SbSafeConfigResp;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-20
 */
public interface ISbSafeConfigService extends IService<SbSafeConfig> {

    SbSafeConfig latest();

    SbSafeConfig create(SbSafeConfigReq req, Authentication authentication);

    IPage<SbSafeConfigResp> list(Page<SbSafeConfigResp> page, Integer type);
}
