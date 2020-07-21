package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbStaffLeaveLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SbStaffLeaveLogResp;

import java.util.List;

/**
 * <p>
 * 请假审核记录 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
public interface SbStaffLeaveLogMapper extends BaseMapper<SbStaffLeaveLog> {

    IPage<SbStaffLeaveLogResp> page(Page<SbStaffLeaveLogResp> page);
    List<SbStaffLeaveLogResp> sList(@Param("leaveId") Long leaveId);

}
