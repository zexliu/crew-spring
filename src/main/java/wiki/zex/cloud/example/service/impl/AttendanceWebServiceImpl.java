package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiki.zex.cloud.example.entity.SbStaffAttendance;
import wiki.zex.cloud.example.exception.NotFoundException;
import wiki.zex.cloud.example.exception.ServerException;
import wiki.zex.cloud.example.service.IAttendanceWebService;
import wiki.zex.cloud.example.service.ISbStaffAttendanceService;
import wiki.zex.cloud.example.utils.DateUtils;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@WebService(serviceName = "AttendanceWebService", // 与接口中指定的name一致
        targetNamespace = "wiki.zex.crew", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "wiki.zex.cloud.example.service.IAttendanceWebService"// 接口地址
)
@Component
public class AttendanceWebServiceImpl implements IAttendanceWebService {

    @Autowired
    private ISbStaffAttendanceService iSbStaffAttendanceService;

    @Override
    public void AlcoholDetectionRecord(Long userId, String username, Integer userTask,
                                       BigDecimal alcoholValue, Integer alcoholResult,
                                       Date recordTime, String recordVideoName, BigDecimal answerAccuracy, String description) {
        LocalDateTime recordDateTime = DateUtils.dateToLocalDateTime(recordTime);

        Map<String, String> descriptionMap = new HashMap<>();
        String[] descriptions = description.split(";");
        for (String s : descriptions) {
            String[] kv = s.split(":");
            if (kv.length < 2) {
                return;
            }
            descriptionMap.put(kv[0], kv[1]);
        }
        if (userTask == 1 || userTask == 2) {
            SbStaffAttendance record = iSbStaffAttendanceService.getOne(new LambdaQueryWrapper<SbStaffAttendance>()
                    .eq(SbStaffAttendance::getStaffId, userId)
                    .eq(SbStaffAttendance::getDate, LocalDate.now()));
            if (record == null) {
                throw new NotFoundException();
            }
            if (userTask == 1) {
                if (record.getAttendanceStatus() != 0) {
                    throw new ServerException("已经有过出勤记录了");
                }
                record.setRealAttendanceAt(recordDateTime.toLocalTime());
                record.setAlcoholResult(alcoholResult);
                record.setAlcoholValue(alcoholValue);
                record.setAnswerAccuracy(answerAccuracy);
                record.setAttendanceDeviceId(descriptionMap.get("设备ID"));
                record.setAttendanceStatus(recordDateTime.toLocalTime().isBefore(LocalTime.now()) ? 1 : 2);
            } else {
                if (record.getBackStatus() != 0) {
                    throw new ServerException("已经有过退勤记录了");
                }
                record.setRealBackAt(recordDateTime.toLocalTime());
                record.setBackDeviceId(descriptionMap.get("设备ID"));
                record.setBackStatus(recordDateTime.toLocalTime().isBefore(LocalTime.now()) ? 1 : 2);
            }
            iSbStaffAttendanceService.updateById(record);
        }

    }

}
