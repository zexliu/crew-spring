package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import wiki.zex.cloud.example.entity.SbSafeConfig;
import wiki.zex.cloud.example.mapper.SbSafeConfigMapper;
import wiki.zex.cloud.example.req.SbSafeConfigReq;
import wiki.zex.cloud.example.resp.SbSafeConfigResp;
import wiki.zex.cloud.example.security.MyUserDetails;
import wiki.zex.cloud.example.service.ISbSafeConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-20
 */
@Service
public class SbSafeConfigServiceImpl extends ServiceImpl<SbSafeConfigMapper, SbSafeConfig> implements ISbSafeConfigService {


    @Override
    public SbSafeConfig latest() {
        return getOne(new LambdaQueryWrapper<SbSafeConfig>().orderByDesc(SbSafeConfig::getCreateAt),false);
    }

    @Override
    public SbSafeConfig create(SbSafeConfigReq req, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        SbSafeConfig config = new SbSafeConfig();
        config.setOperatorId(myUserDetails.getId());
        BeanUtils.copyProperties(req,config);
        save(config);
        return config;
    }

    @Override
    public IPage<SbSafeConfigResp> list(Page<SbSafeConfigResp> page, Integer type) {
        return baseMapper.list(page,type);
    }
}
