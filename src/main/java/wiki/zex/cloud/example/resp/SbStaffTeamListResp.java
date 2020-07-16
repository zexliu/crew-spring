package wiki.zex.cloud.example.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;
import wiki.zex.cloud.example.entity.SbStaffTeam;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 机队
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbStaffTeam对象", description="机队")
public class SbStaffTeamListResp extends SbStaffTeam {

    String leaderDescriptions;
}
