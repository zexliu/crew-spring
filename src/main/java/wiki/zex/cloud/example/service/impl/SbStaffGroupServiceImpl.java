package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.zex.cloud.example.entity.SbStaffGroup;
import wiki.zex.cloud.example.mapper.SbStaffGroupMapper;
import wiki.zex.cloud.example.req.SbStaffGroupReq;
import wiki.zex.cloud.example.resp.SbStaffGroupListResp;
import wiki.zex.cloud.example.resp.SbStaffGroupResp;
import wiki.zex.cloud.example.service.ISbStaffGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wiki.zex.cloud.example.service.ISbStaffService;

/**
 * <p>
 * 机队组 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Service
public class SbStaffGroupServiceImpl extends ServiceImpl<SbStaffGroupMapper, SbStaffGroup> implements ISbStaffGroupService {


    @Autowired
    private ISbStaffService iSbStaffService;

    @Override
    public void removeByTeamId(Long id) {
        remove(new LambdaQueryWrapper<SbStaffGroup>().eq(SbStaffGroup::getTeamId, id));
    }

    @Override
    public SbStaffGroup updateById(Long id, SbStaffGroupReq req) {
        SbStaffGroup group = new SbStaffGroup();
        BeanUtils.copyProperties(req, group);
        group.setId(id);
        updateById(group);
        iSbStaffService.updateGroupLeaders(group.getId(),req.getLeaderIds());
        return group;
    }

    @Override
    public SbStaffGroup create(SbStaffGroupReq req) {
        SbStaffGroup group = new SbStaffGroup();
        BeanUtils.copyProperties(req, group);
        save(group);
        iSbStaffService.updateGroupLeaders(group.getId(),req.getLeaderIds());
        return group;
    }

    @Override
    public void delete(Long id) {
        iSbStaffService.removeByGroupId(id);
        removeById(id);
    }

    @Override
    public Page<SbStaffGroupListResp> page(Page<SbStaffGroup> page, Long teamId, String groupName) {
        return baseMapper.page(page,teamId,groupName);
    }

    @Override
    public SbStaffGroupResp getDetails(Long id) {
        return baseMapper.getDetails(id);
    }


}
