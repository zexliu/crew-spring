package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SbStaffTeamReq {

    @ApiModelProperty(value = "机队名称")
    @NotBlank
    private String teamName;

    @ApiModelProperty(value = "联系电话")
    @Length(max = 30)
    private String teamPhone;

    @ApiModelProperty(value = "机队类型")
    private Integer groupType;
    @Length(max = 200)
    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "机队负责人Id集合")
    private List<Long> leaderIds;
}
