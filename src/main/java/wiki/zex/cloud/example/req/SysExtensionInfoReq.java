package wiki.zex.cloud.example.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class SysExtensionInfoReq {

    @NotBlank
    private String fieldCode;

    @ApiModelProperty(value = "实例ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long instanceId;

    @ApiModelProperty(value = "整型")
    private Long longValue;

    @ApiModelProperty(value = "浮点型")
    private Double doubleValue;

    @ApiModelProperty(value = "字符串")
    private String TextValue;

}
