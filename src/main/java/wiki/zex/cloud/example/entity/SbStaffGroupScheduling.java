package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 机组轮换信息
 * </p>
 *
 * @author Zex
 * @since 2020-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SbStaffGroupScheduling对象", description="机组轮换信息")
public class SbStaffGroupScheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "日期")
    private LocalDate date;

    @ApiModelProperty(value = "交路项ID")
    private Long routeItemId;

    @ApiModelProperty(value = "机组ID")
    private Long staffGroupId;


}
