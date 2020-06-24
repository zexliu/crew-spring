package wiki.zex.cloud.example.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

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
@ApiModel(value="SbRouteItem对象", description="交路计划明细表")
public class SbRouteItemReq  {

    @ApiModelProperty(value = "交路表ID")
    @NotNull
    private Long tableId;

    @ApiModelProperty(value = "班次ID")
    @NotNull
    private Long shiftId;

    @ApiModelProperty(value = "交路号")
    private String routeItemNo;

    @ApiModelProperty(value = "出勤站点")
    @NotNull
    private Long attendanceStationId;

    @ApiModelProperty(value = "出勤时间")
    @NotNull
    private LocalDateTime attendanceAt;

    @ApiModelProperty(value = "接车时间")
    @NotNull
    private LocalDateTime meetAt;

    @ApiModelProperty(value = "接车车次")
    @NotBlank
    private String meetTrainNo;

    @ApiModelProperty(value = "接车站点")
    @NotNull
    private Long meetStationId;

    @ApiModelProperty(value = "开行交路")
    @NotBlank
    private String trainNumbers;

    @ApiModelProperty(value = "退勤车次")
    @NotBlank
    private String backTrainNo;

    @ApiModelProperty(value = "退勤地点")
    @NotNull
    private Long backStationId;

    @ApiModelProperty(value = "退勤时间")
    @NotNull
    private LocalDateTime backAt;

    @ApiModelProperty(value = "备注")
    @Length(max = 200)
    private String remark;

    @ApiModelProperty(value = "描述")
    @Length(max = 200)
    private String description;

}
