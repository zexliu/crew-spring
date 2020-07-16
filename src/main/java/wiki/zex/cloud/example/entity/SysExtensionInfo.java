package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 拓展信息值
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysExtensionInfo对象", description="拓展信息值")
public class SysExtensionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    @ApiModelProperty(value = "字段编码")
    private String fieldCode;

    @ApiModelProperty(value = "实例ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long instanceId;

    @ApiModelProperty(value = "整型")
    private Long longValue;

    @ApiModelProperty(value = "浮点型")
    private Double doubleValue;

    @ApiModelProperty(value = "字符串")
    private String textValue;


}
