package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;

/**
 * <p>
 * 班次
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbShift对象", description="班次")
public class SbShift implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using= JsonLongSerializer.class)
    private Long id;

    @JsonSerialize(using= JsonLongSerializer.class)
    private Long shiftGroupId;

    @ApiModelProperty(value = "班次名称")
    private String shiftName;

    @ApiModelProperty(value = "排序")
    private Integer seq;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;


}
