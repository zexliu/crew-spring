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
 * 机队轮换信息
 * </p>
 *
 * @author Zex
 * @since 2020-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SbStaffTeamScheduling对象", description="机队轮换信息")
public class SbStaffTeamScheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "日期")
    private LocalDate date;

    @ApiModelProperty(value = "班次组ID")
    private Long shiftGroupId;

    @ApiModelProperty(value = "机队ID")
    private Long staffTeamId;


}
