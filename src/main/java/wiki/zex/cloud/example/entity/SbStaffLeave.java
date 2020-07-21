package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
import wiki.zex.cloud.example.enums.LeaveStatus;

/**
 * <p>
 * 请假表
 * </p>
 *
 * @author Zex
 * @since 2020-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SbStaffLeave对象", description="请假表")
public class SbStaffLeave implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    @ApiModelProperty(value = "请假类型")
    private Integer type;

    @ApiModelProperty(value = "人员ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "审批状态")
    private LeaveStatus status;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "离队日期")
    private LocalDate leaveAt;

    @ApiModelProperty(value = "归队日期")
    private LocalDate backAt;

    @ApiModelProperty(value = "天数")
    private Integer days;


}
