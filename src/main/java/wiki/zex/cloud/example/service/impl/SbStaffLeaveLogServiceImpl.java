package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbStaffLeaveLog;
import wiki.zex.cloud.example.mapper.SbStaffLeaveLogMapper;
import wiki.zex.cloud.example.resp.SbStaffLeaveLogResp;
import wiki.zex.cloud.example.service.ISbStaffLeaveLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 请假审核记录 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
@Service
public class SbStaffLeaveLogServiceImpl extends ServiceImpl<SbStaffLeaveLogMapper, SbStaffLeaveLog> implements ISbStaffLeaveLogService {

    @Override
    public IPage<SbStaffLeaveLogResp> mPage(Page<SbStaffLeaveLogResp> page) {
        return baseMapper.page(page);
    }
}
