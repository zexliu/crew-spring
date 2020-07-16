package wiki.zex.cloud.example.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SbStaffGroupReq {

    @ApiModelProperty(value = "机队ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    @NotNull
    private Long teamId;

    @ApiModelProperty(value = "机组名称")
    @NotBlank
    private String groupName;

    @ApiModelProperty(value = "描述")
    @Length(max = 200)
    private String description;

    @ApiModelProperty(value = "机组负责人Id集合")
    private List<Long> leaderIds;

    @ApiModelProperty(value = "机组电话")
    private String groupPhone;


}
