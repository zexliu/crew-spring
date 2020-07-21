package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDate;
@Data
public class SbSafeConfigReq {


    @ApiModelProperty(value = "重大安全事故")
    private LocalDate safe1At;

    @ApiModelProperty(value = "大安全事故")
    private LocalDate safe2At;

    @ApiModelProperty(value = "较大安全事故")
    private LocalDate safe3At;

    @ApiModelProperty(value = "一般安全事故")
    private LocalDate safe4At;

    @ApiModelProperty(value = "老动人身安全事故")
    private LocalDate safe5At;

    @ApiModelProperty(value = "操作类型")
    private Integer type;

    @ApiModelProperty(value = "备注")
    private String description;

}
