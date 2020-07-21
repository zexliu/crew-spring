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
import wiki.zex.cloud.example.enums.LeaveLogType;

/**
 * <p>
 * 请假审核记录
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SbStaffLeaveLog对象", description="请假审核记录")
public class SbStaffLeaveLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)

    private Long id;
    @JsonSerialize(using = JsonLongSerializer.class)

    @ApiModelProperty(value = "请假ID")
    private Long leaveId;

    @ApiModelProperty(value = "操作人ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long operatorId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "记录类型")
    private LeaveLogType type;


}
