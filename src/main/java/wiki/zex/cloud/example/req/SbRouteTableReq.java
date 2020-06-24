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
 * 交路计划表
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbRouteTable对象", description="交路计划表")
public class SbRouteTableReq implements Serializable {


    @ApiModelProperty(value = "交路计划名称")
    @NotBlank
    @Length(min = 2,max = 30)
    private String tableName;

    @ApiModelProperty(value = "运行时刻表ID")
    @NotNull
    private Long runtimeTableId;

    @ApiModelProperty(value = "描述")
    @Length(max = 200)
    private String description;

}
