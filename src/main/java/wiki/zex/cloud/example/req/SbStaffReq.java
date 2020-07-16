package wiki.zex.cloud.example.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;
import wiki.zex.cloud.example.enums.GenderType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SbStaffReq {


    @ApiModelProperty(value = "技能")
    private String skills;

    @ApiModelProperty(value = "安全时间")
    private LocalDateTime safeAt;

    @ApiModelProperty(value = "机队ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    @NotNull
    private Long teamId;

    @ApiModelProperty(value = "机组ID")
    @JsonSerialize(using = JsonLongSerializer.class)
    @NotNull
    private Long groupId;

    @ApiModelProperty(value = "是否机队负责人")
    private Boolean isTeamLeader;

    @ApiModelProperty(value = "是否机组负责人")
    private Boolean isGroupLeader;

    @ApiModelProperty(value = "职务")
    private Integer jobTitle;

    @NotBlank
    @Length(min = 2, max = 10)
    private String realName;

    @Length(min = 2, max = 20)
    private String nickname;

    private String avatar;

    @NotBlank
    @Length(min = 11, max = 11)
    private String mobile;

    @Length(max = 30)
    private String workNo;

    @Length(min = 8, max = 30)
    private String email;

    private GenderType gender;

    private LocalDate birthDay;


    private List<SysExtensionInfoSimpleReq> extensions;

}
