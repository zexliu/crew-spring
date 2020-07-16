package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.zex.cloud.example.entity.SbStaffTeam;
import wiki.zex.cloud.example.mapper.SbStaffTeamMapper;
import wiki.zex.cloud.example.req.SbStaffTeamReq;
import wiki.zex.cloud.example.resp.SbStaffTeamListResp;
import wiki.zex.cloud.example.resp.SbStaffTeamResp;
import wiki.zex.cloud.example.service.ISbStaffGroupService;
import wiki.zex.cloud.example.service.ISbStaffService;
import wiki.zex.cloud.example.service.ISbStaffTeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机队 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Service
public class SbStaffTeamServiceImpl extends ServiceImpl<SbStaffTeamMapper, SbStaffTeam> implements ISbStaffTeamService {

    @Autowired
    private ISbStaffGroupService iSbStaffGroupService;

    @Autowired
    private ISbStaffService iSbStaffService;

    @Override
    public SbStaffTeam create(SbStaffTeamReq req) {
        SbStaffTeam team = new SbStaffTeam();
        BeanUtils.copyProperties(req, team);
        save(team);
        iSbStaffService.updateTeamLeaders(team.getId(),req.getLeaderIds());
        return team;
    }

    @Override
    public SbStaffTeam updateById(Long id, SbStaffTeamReq req) {
        SbStaffTeam team = new SbStaffTeam();
        BeanUtils.copyProperties(req, team);
        team.setId(id);
        updateById(team);
        iSbStaffService.updateTeamLeaders(team.getId(),req.getLeaderIds());
        return team;
    }


    @Override
    public void delete(Long id) {
        removeById(id);
        iSbStaffGroupService.removeByTeamId(id);
        iSbStaffService.removeByTeamId(id);
    }

    @Override
    public IPage<SbStaffTeamListResp> list(Page<SbStaffTeamListResp> convert, String teamName) {
        return baseMapper.list(convert,teamName);
    }

    @Override
    public SbStaffTeamResp getDetails(Long id) {
        return baseMapper.getDetails(id);
    }
}
