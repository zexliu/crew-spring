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
 * 机队组
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbStaffGroup对象", description="机队组")
public class SbStaffGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    @ApiModelProperty(value = "机队ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long teamId;

    private String groupName;

    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "轮换次数")
    private Integer rotateCount;

    private Integer rotateStatus;

    private String groupPhone;
}
