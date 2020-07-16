package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbStaffGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SbStaffGroupListResp;
import wiki.zex.cloud.example.resp.SbStaffGroupResp;
import wiki.zex.cloud.example.resp.SbStaffTeamResp;

/**
 * <p>
 * 机队组 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface SbStaffGroupMapper extends BaseMapper<SbStaffGroup> {

    Page<SbStaffGroupListResp> page(Page<SbStaffGroup> page, @Param("teamId") Long teamId, @Param("groupName") String groupName);

    SbStaffGroupResp getDetails(@Param("id")Long id);
}
