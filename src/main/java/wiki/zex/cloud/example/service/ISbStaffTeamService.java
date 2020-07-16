package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbStaffTeam;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbStaffTeamReq;
import wiki.zex.cloud.example.resp.SbStaffTeamListResp;
import wiki.zex.cloud.example.resp.SbStaffTeamResp;

/**
 * <p>
 * 机队 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface ISbStaffTeamService extends IService<SbStaffTeam> {

    SbStaffTeam create(SbStaffTeamReq req);

    SbStaffTeam updateById(Long id, SbStaffTeamReq req);

    void delete(Long id);

   IPage<SbStaffTeamListResp> list(Page<SbStaffTeamListResp> convert, String teamName);

    SbStaffTeamResp getDetails(Long id);
}
