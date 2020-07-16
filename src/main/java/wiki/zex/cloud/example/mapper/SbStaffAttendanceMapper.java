package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbStaffAttendance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SbStaffAttendanceResp;

import java.time.LocalDate;

/**
 * <p>
 * 出勤记录 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-07-13
 */
public interface SbStaffAttendanceMapper extends BaseMapper<SbStaffAttendance> {


    IPage<SbStaffAttendanceResp> list(Page<SbStaffAttendanceResp> page,
                                      @Param("staffId")Long staffId,
                                      @Param("alcoholResult")Integer alcoholResult,
                                      @Param("attendanceStatus")Integer attendanceStatus,
                                      @Param("backStatus")Integer backStatus,
                                      @Param("answerStatus")Integer answerStatus,
                                      @Param("date")LocalDate date);

}
