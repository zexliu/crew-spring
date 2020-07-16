package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import wiki.zex.cloud.example.enums.NotificationChannelType;

import java.util.List;

@Data
public class SnNotificationReq {

    @ApiModelProperty(value = "参数")
    private String params;

    @ApiModelProperty(value = "发布渠道")
    private NotificationChannelType channelType;

    @ApiModelProperty(value = "发布类型 1全员 2指定")
    private Integer publishType;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    private List<Long> userIds;

}
