package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbStaffLeave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.enums.LeaveStatus;
import wiki.zex.cloud.example.resp.SbStaffLeaveDetails;
import wiki.zex.cloud.example.resp.SbStaffLeaveResp;

/**
 * <p>
 * 请假表 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
public interface SbStaffLeaveMapper extends BaseMapper<SbStaffLeave> {

    IPage<SbStaffLeaveResp> leaves(Page<SbStaffLeaveResp> page,
                                   @Param("status") LeaveStatus status,
                                   @Param("type") Integer type,
                                   @Param("userId") Long userId);


    SbStaffLeaveDetails details(Long id);
}
