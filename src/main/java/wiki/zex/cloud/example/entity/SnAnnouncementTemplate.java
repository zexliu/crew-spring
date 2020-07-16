package wiki.zex.cloud.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

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
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SnAnnouncementTemplate对象", description = "")
public class SnAnnouncementTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @ApiModelProperty(value = "模板编码")

    private String templateCode;
    @ApiModelProperty(value = "模板标题")

    private String templateTitle;
    @ApiModelProperty(value = "模板内容")

    private String templateContent;

    @ApiModelProperty(value = "公告类型")

    private Integer announcementType;
    @ApiModelProperty(value = "创建时间")

    private LocalDateTime createAt;


}
