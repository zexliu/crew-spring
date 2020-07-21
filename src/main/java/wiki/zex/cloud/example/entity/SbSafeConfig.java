package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zex
 * @since 2020-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SbSafeConfig对象", description="")
public class SbSafeConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "重大安全事故")
    private LocalDate safe1At;

    @ApiModelProperty(value = "大安全事故")
    private LocalDate safe2At;

    @ApiModelProperty(value = "较大安全事故")
    private LocalDate safe3At;

    @ApiModelProperty(value = "一般安全事故")
    private LocalDate safe4At;

    @ApiModelProperty(value = "老动人身安全事故")
    private LocalDate safe5At;

    @ApiModelProperty(value = "操作类型")
    private Integer type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "操作人ID")
    private Long operatorId;


}
