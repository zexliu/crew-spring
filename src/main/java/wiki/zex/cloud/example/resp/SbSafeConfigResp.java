package wiki.zex.cloud.example.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import wiki.zex.cloud.example.entity.SbSafeConfig;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@ApiModel(value="SbSafeConfig对象", description="")
public class SbSafeConfigResp extends SbSafeConfig {
    private String nickname;
}
