package wiki.zex.cloud.example.schedule;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import wiki.zex.cloud.example.entity.SbStaffAttendance;
import wiki.zex.cloud.example.resp.SbStaffResp;
import wiki.zex.cloud.example.resp.SbStaffSchedulingDayResp;
import wiki.zex.cloud.example.service.ISbStaffAttendanceService;
import wiki.zex.cloud.example.service.ISbStaffService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class SbAttendanceJob extends QuartzJobBean {

    @Autowired
    private ISbStaffService iSbStaffService;


    @Autowired
    private ISbStaffAttendanceService iSbStaffAttendanceService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info(" ----------  do job ----------");
        LocalDate nextDay = LocalDate.now().plusDays(1);
        List<SbStaffAttendance> sbStaffAttendances = new ArrayList<>();
        IPage<SbStaffSchedulingDayResp> day = iSbStaffService.day(new Page<>(0, 9999), nextDay, null, null, null, null, null);
        for (SbStaffSchedulingDayResp record : day.getRecords()) {
            for (SbStaffResp staff : record.getStaffs()) {
                SbStaffAttendance attendance = new SbStaffAttendance();
                attendance.setStaffId(staff.getId());
                attendance.setAttendanceAt(record.getAttendanceAt());
                attendance.setBackAt(record.getBackAt());
                attendance.setRouteItemId(record.getRouteItemId());
                attendance.setDate(nextDay);
                attendance.setRouteItemNo(record.getRouteItemNo());
                attendance.setStaffTeamId(staff.getTeamId());
                attendance.setStaffGroupId(staff.getGroupId());
                attendance.setDistance(record.getDistance());
                attendance.setDuration(record.getBackAt().toSecondOfDay() - record.getAttendanceAt().toSecondOfDay());
                sbStaffAttendances.add(attendance);
            }
        }
        if (CollectionUtils.isNotEmpty(sbStaffAttendances)){
            iSbStaffAttendanceService.saveBatch(sbStaffAttendances);
        }
    }
}
