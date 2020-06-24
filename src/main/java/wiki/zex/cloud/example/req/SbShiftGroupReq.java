package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SbShiftGroupReq {

    @NotBlank
    private String groupName;

    private Integer seq;

    @ApiModelProperty(value = "描述")
    private String description;


}
