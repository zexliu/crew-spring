package wiki.zex.cloud.example.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;
import java.time.LocalTime;

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
 * 出勤记录
 * </p>
 *
 * @author Zex
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SbStaffAttendance对象", description = "出勤记录")
public class SbStaffAttendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    @JsonSerialize(using = JsonLongSerializer.class)
    @ApiModelProperty(value = "司机ID")
    private Long staffId;

    @JsonSerialize(using = JsonLongSerializer.class)
    @ApiModelProperty(value = "交路ID")
    private Long routeItemId;

    @ApiModelProperty(value = "交路号")
    private String routeItemNo;

    @ApiModelProperty(value = "日期")
    private LocalDate date;

    @ApiModelProperty(value = "出勤时间")
    private LocalTime attendanceAt;

    @ApiModelProperty(value = "退勤时间")
    private LocalTime backAt;

    @ApiModelProperty(value = "实际出勤时间")
    private LocalTime realAttendanceAt;

    @ApiModelProperty(value = "实际退勤时间")
    private LocalTime realBackAt;

    @ApiModelProperty(value = "出勤设备ID")
    private String attendanceDeviceId;

    @ApiModelProperty(value = "出勤设备ID")
    private String backDeviceId;

    @ApiModelProperty(value = "考试分数")
    private BigDecimal answerAccuracy;

    @ApiModelProperty(value = "测酒值")
    private BigDecimal alcoholValue;

    @ApiModelProperty(value = "测酒结果 0正常；1饮酒；2酗酒")
    private Integer alcoholResult;

    @ApiModelProperty(value = "出勤状态 0 未出勤  1 正常 2 迟到")
    private Integer attendanceStatus;

    @ApiModelProperty(value = "退勤状态 0 未退勤  1 正常 2 早退")
    private Integer backStatus;
    @ApiModelProperty(value = "机队")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long staffTeamId;
    @ApiModelProperty(value = "机组")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long staffGroupId;

    @ApiModelProperty(value = "行驶里程")
    private Double distance;

    @ApiModelProperty(value = "有效时长")
    private Integer duration;

}
