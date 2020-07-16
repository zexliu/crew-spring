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
 * 机队
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbStaffTeam对象", description="机队")
public class SbStaffTeam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    @ApiModelProperty(value = "班组名称")
    private String teamName;

    @ApiModelProperty(value = "联系电话")
    private String teamPhone;

    @ApiModelProperty(value = "轮换次数")
    private Integer rotateCount;

    @ApiModelProperty(value = "轮换状态")
    private Integer rotateStatus;

    @ApiModelProperty(value = "班组类型")
    private Integer groupType;

    private LocalDateTime createAt;

    @ApiModelProperty(value = "描述")
    private String description;


}
