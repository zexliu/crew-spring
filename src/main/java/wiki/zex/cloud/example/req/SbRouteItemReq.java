package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

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

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "交路表ID")
    @NotNull
    private Long tableId;

    @ApiModelProperty(value = "班次ID")
    @NotNull
    private Long shiftGroupId;

    @ApiModelProperty(value = "班次ID")
    @NotNull
    private Long shiftId;

    @ApiModelProperty(value = "交路号")
    private String routeItemNo;

    @ApiModelProperty(value = "出勤站点点")
    @NotNull
    private Long attendanceStationId;

    @ApiModelProperty(value = "出勤时间")
    @NotNull
    private LocalTime attendanceAt;

    @ApiModelProperty(value = "接车时间")
    @NotNull
    private LocalTime meetAt;

    @ApiModelProperty(value = "接车车次")
    @NotNull
    private Long meetRuntimeItemId;

    @ApiModelProperty(value = "接车第点")
    @NotNull
    private Long meetStationId;

    @ApiModelProperty(value = "退勤车次")
    @NotNull
    private Long backRuntimeItemId;

    @ApiModelProperty(value = "退勤地点")
    @NotNull
    private Long backStationId;

    @ApiModelProperty(value = "退勤时间")
    @NotNull
    private LocalTime backAt;

    @ApiModelProperty(value = "总公里数")
    @NotNull
    private Double distance;

    @ApiModelProperty(value = "备注")
    @Length(max = 200)
    private String remark;

    @ApiModelProperty(value = "描述")
    @Length(max = 200)
    private String description;


    @ApiModelProperty(value = "开行交路")
    private List<Long> runtimeItemIds;
}
