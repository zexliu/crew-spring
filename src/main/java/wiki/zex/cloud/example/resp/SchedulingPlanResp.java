package wiki.zex.cloud.example.resp;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;

import java.time.LocalTime;

@Data
public class SchedulingPlanResp {

    String routeItemNo;
    LocalTime attendanceAt;
    @JsonSerialize(using = JsonLongSerializer.class)
    Long attendanceStationId;
    LocalTime backAt;
    @JsonSerialize(using = JsonLongSerializer.class)
    Long backStationId;
    LocalTime meetAt;
    @JsonSerialize(using = JsonLongSerializer.class)
    Long meetStationId;
    @JsonSerialize(using = JsonLongSerializer.class)
    Long staffTeamId;
    @JsonSerialize(using = JsonLongSerializer.class)
    Long staffGroupId;

}
