package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import wiki.zex.cloud.example.enums.ExtensionFieldType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysExtensionFieldReq {

    @NotBlank
    @Length(min = 2,max = 32)
    @ApiModelProperty(value = "表名")
    private String tableName;

    @NotBlank
    @Length(min = 2,max = 32)
    @ApiModelProperty(value = "字段编码")
    private String fieldCode;

    @NotBlank
    @Length(min = 2,max = 32)
    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @NotNull
    @ApiModelProperty(value = "字段类型")
    private ExtensionFieldType fieldType;


}
