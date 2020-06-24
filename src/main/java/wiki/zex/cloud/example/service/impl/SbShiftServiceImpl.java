package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.BeanUtils;
import wiki.zex.cloud.example.entity.SbShift;
import wiki.zex.cloud.example.mapper.SbShiftMapper;
import wiki.zex.cloud.example.req.SbShiftReq;
import wiki.zex.cloud.example.service.ISbShiftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班次 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Service
public class SbShiftServiceImpl extends ServiceImpl<SbShiftMapper, SbShift> implements ISbShiftService {

    @Override
    public void removeByGroupId(Long id) {
        remove(new LambdaUpdateWrapper<SbShift>().eq(SbShift::getShiftGroupId,id));
    }

    @Override
    public SbShift create(SbShiftReq req) {
        SbShift sbShift = new SbShift();
        BeanUtils.copyProperties(req,sbShift);
        save(sbShift);
        return sbShift;
    }

    @Override
    public SbShift update(Long id, SbShiftReq req) {
        SbShift sbShift = new SbShift();
        BeanUtils.copyProperties(req,sbShift);
        sbShift.setId(id);
        updateById(sbShift);
        return sbShift;
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }
}
