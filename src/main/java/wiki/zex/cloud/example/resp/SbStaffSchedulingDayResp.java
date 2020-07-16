package wiki.zex.cloud.example.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;

import java.time.LocalTime;
import java.util.List;

@Data
public class SbStaffSchedulingDayResp {

    @JsonSerialize(using = JsonLongSerializer.class)
    Long shiftId;
    @JsonSerialize(using = JsonLongSerializer.class)
    Long shiftGroupId;

    @JsonSerialize(using = JsonLongSerializer.class)
    Long routeItemId;

    String routeItemNo;

    @JsonSerialize(using = JsonLongSerializer.class)
    Long staffTeamId;

    @JsonSerialize(using = JsonLongSerializer.class)
    Long staffGroupId;

    List<SbStaffResp> staffs;

    private LocalTime attendanceAt;

    private LocalTime backAt;

    private Double distance;

}
