package wiki.zex.cloud.example.service;


import javax.jws.WebService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@WebService(name = "AttendanceWebService", // 暴露服务名称
        targetNamespace = "wiki.zex.crew"// 命名空间,一般是接口的包名倒序
)
public interface IAttendanceWebService {

    void AlcoholDetectionRecord(Long userId, String username, Integer userTask, BigDecimal alcoholValue, Integer alcoholResult, Date recordTime, String recordVideoName, BigDecimal answerAccuracy, String description);
}
