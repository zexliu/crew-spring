package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 交路明细时刻明细关联关系
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbRouteRuntimeRel对象", description="交路明细时刻明细关联关系")
public class SbRouteRuntimeRel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long routeItemId;

    private Long runtimeItemId;


}
