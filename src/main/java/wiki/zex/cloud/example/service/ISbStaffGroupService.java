package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbStaffGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbStaffGroupReq;
import wiki.zex.cloud.example.resp.SbStaffGroupListResp;
import wiki.zex.cloud.example.resp.SbStaffGroupResp;
import wiki.zex.cloud.example.resp.SbStaffTeamResp;

/**
 * <p>
 * 机队组 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface ISbStaffGroupService extends IService<SbStaffGroup> {

    void removeByTeamId(Long id);

    SbStaffGroup updateById(Long id, SbStaffGroupReq req);


    SbStaffGroup create(SbStaffGroupReq req);

    void delete(Long id);


    Page<SbStaffGroupListResp> page(Page<SbStaffGroup> convert, Long teamId, String groupName);

    SbStaffGroupResp getDetails(Long id);
}
