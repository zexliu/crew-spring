package wiki.zex.cloud.example.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.zex.cloud.example.entity.SbShiftGroup;
import wiki.zex.cloud.example.mapper.SbShiftGroupMapper;
import wiki.zex.cloud.example.req.SbShiftGroupReq;
import wiki.zex.cloud.example.service.ISbShiftGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wiki.zex.cloud.example.service.ISbShiftService;

/**
 * <p>
 * 班次所属 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Service
public class SbShiftGroupServiceImpl extends ServiceImpl<SbShiftGroupMapper, SbShiftGroup> implements ISbShiftGroupService {

    @Autowired
    private ISbShiftService iSbShiftService;
    @Override
    public SbShiftGroup create(SbShiftGroupReq req) {
        SbShiftGroup sbShiftGroup = new SbShiftGroup();
        BeanUtils.copyProperties(req,sbShiftGroup);
        save(sbShiftGroup);
        return sbShiftGroup;
    }

    @Override
    public SbShiftGroup update(Long id, SbShiftGroupReq req) {
        SbShiftGroup sbShiftGroup = new SbShiftGroup();
        BeanUtils.copyProperties(req,sbShiftGroup);
        sbShiftGroup.setId(id);
        updateById(sbShiftGroup);
        return sbShiftGroup;
    }

    @Override
    public void delete(Long id) {
        iSbShiftService.removeByGroupId(id);
        removeById(id);
    }
}
