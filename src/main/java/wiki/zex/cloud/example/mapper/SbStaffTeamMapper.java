package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbStaffTeam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SbStaffTeamListResp;
import wiki.zex.cloud.example.resp.SbStaffTeamResp;

/**
 * <p>
 * 机队 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface SbStaffTeamMapper extends BaseMapper<SbStaffTeam> {

    IPage<SbStaffTeamListResp> list(Page<SbStaffTeamListResp> convert, @Param("teamName") String teamName);

    SbStaffTeamResp getDetails(@Param("id") Long id);

}
