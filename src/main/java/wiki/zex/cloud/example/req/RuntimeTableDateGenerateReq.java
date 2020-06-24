package wiki.zex.cloud.example.req;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

@Data
public class RuntimeTableDateGenerateReq {


    private LocalDate startAt;

    private LocalDate endAt;

    private Map<DayOfWeek,Long> generateRules;
//
//    @Data
//    static class RuntimeTableDateGenerateRule {
//
//        private Long tableId;
//
//        private DayOfWeek week;
//
//    }
}



