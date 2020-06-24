package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 交路计划明细表
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SbRouteItem对象", description="交路计划明细表")
public class SbRouteItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "交路表ID")
    private Long tableId;

    @ApiModelProperty(value = "班次ID")
    private Long shiftId;

    @ApiModelProperty(value = "交路号")
    private String routeItemNo;

    @ApiModelProperty(value = "出勤站点")
    private Long attendanceStationId;

    @ApiModelProperty(value = "出勤时间")
    private LocalDateTime attendanceAt;

    @ApiModelProperty(value = "接车时间")
    private LocalDateTime meetAt;

    @ApiModelProperty(value = "接车车次")
    private String meetTrainNo;

    @ApiModelProperty(value = "接车站点")
    private Long meetStationId;

    @ApiModelProperty(value = "开行交路")
    private String trainNumbers;

    @ApiModelProperty(value = "退勤车次")
    private String backTrainNo;

    @ApiModelProperty(value = "退勤地点")
    private Long backStationId;

    @ApiModelProperty(value = "退勤时间")
    private LocalDateTime backAt;

    @ApiModelProperty(value = "总公里数")
    private Double distance;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;


}
