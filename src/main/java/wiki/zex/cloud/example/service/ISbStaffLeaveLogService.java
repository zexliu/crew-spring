package wiki.zex.cloud.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbStaffLeaveLog;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.resp.SbStaffLeaveLogResp;

/**
 * <p>
 * 请假审核记录 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
public interface ISbStaffLeaveLogService extends IService<SbStaffLeaveLog> {

    IPage<SbStaffLeaveLogResp> mPage(Page<SbStaffLeaveLogResp> page);

}
