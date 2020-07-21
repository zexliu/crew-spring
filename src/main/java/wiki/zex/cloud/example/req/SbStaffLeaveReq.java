package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SbStaffLeaveReq {
    @ApiModelProperty(value = "请假类型")
    private Integer type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "离队日期")
    private LocalDate leaveAt;

    @ApiModelProperty(value = "归队日期")
    private LocalDate backAt;


}
