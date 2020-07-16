package wiki.zex.cloud.example.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.entity.SnNotification;
import wiki.zex.cloud.example.entity.SyUser;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SnNotificationDetail extends SnNotification {

    List<SyUser> users;

}
