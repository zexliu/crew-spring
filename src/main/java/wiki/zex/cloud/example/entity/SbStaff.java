package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;
/**
 * <p>
 * 
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbStaff对象", description="")
public class SbStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    @JsonSerialize(using = JsonLongSerializer.class)
    private Long userId;

    @ApiModelProperty(value = "指纹")
    private String fingerprint;

    @ApiModelProperty(value = "技能")
    private String skills;

    @ApiModelProperty(value = "安全时间")
    private LocalDateTime safeAt;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "队伍ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long teamId;

    @ApiModelProperty(value = "组ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long groupId;

    @ApiModelProperty(value = "是否机队负责人")
    private Boolean isTeamLeader;

    @ApiModelProperty(value = "是否机组负责人")
    private Boolean isGroupLeader;

    @ApiModelProperty(value = "职务")
    private Integer jobTitle;
}
