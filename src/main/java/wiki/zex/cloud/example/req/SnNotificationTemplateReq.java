package wiki.zex.cloud.example.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import wiki.zex.cloud.example.enums.NotificationChannelType;

@Data
public class SnNotificationTemplateReq {


    @ApiModelProperty(value = "模板编码")
    private String templateCode;

    @ApiModelProperty(value = "模板标题")
    private String templateTitle;

    @ApiModelProperty(value = "模板内容")
    private String templateContent;

    @ApiModelProperty(value = "发布渠道")
    private NotificationChannelType channelType;
}
