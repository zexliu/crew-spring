package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zex.cloud.example.entity.SbStaffAttendance;
import wiki.zex.cloud.example.mapper.SbStaffAttendanceMapper;
import wiki.zex.cloud.example.resp.SbStaffAttendanceResp;
import wiki.zex.cloud.example.service.ISbStaffAttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 出勤记录 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-07-13
 */
@Service
public class SbStaffAttendanceServiceImpl extends ServiceImpl<SbStaffAttendanceMapper, SbStaffAttendance> implements ISbStaffAttendanceService {

    @Override
    public IPage<SbStaffAttendanceResp> list(Page<SbStaffAttendanceResp> page, Long staffId, Integer alcoholResult, Integer attendanceStatus, Integer backStatus, Integer answerStatus, LocalDate date) {
        return baseMapper.list(page,staffId,alcoholResult,attendanceStatus,backStatus,answerStatus,date);
    }

    @Override
    public IPage<SbStaffAttendanceResp> led(Page<SbStaffAttendanceResp> page) {
        return baseMapper.led(page);
    }
}
