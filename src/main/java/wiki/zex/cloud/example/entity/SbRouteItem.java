package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 交路计划明细表
 * </p>
 *
 * @author Zex
 * @since 2020-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbRouteItem对象", description="交路计划明细表")
public class SbRouteItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    @ApiModelProperty(value = "交路表ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long tableId;

    @ApiModelProperty(value = "班次")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long shiftId;

    @ApiModelProperty(value = "交路号")
    private String routeItemNo;

    @ApiModelProperty(value = "出勤站点点")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long attendanceStationId;

    @ApiModelProperty(value = "出勤时间")
    private LocalTime attendanceAt;

    @ApiModelProperty(value = "接车时间")
    private LocalTime meetAt;

    @ApiModelProperty(value = "接车车次")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long meetRuntimeItemId;

    @ApiModelProperty(value = "接车第点")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long meetStationId;

    @ApiModelProperty(value = "退勤车次")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long backRuntimeItemId;

    @ApiModelProperty(value = "退勤地点")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long backStationId;

    @ApiModelProperty(value = "退勤时间")
    private LocalTime backAt;

    @ApiModelProperty(value = "总公里数")
    private Double distance;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;


}
