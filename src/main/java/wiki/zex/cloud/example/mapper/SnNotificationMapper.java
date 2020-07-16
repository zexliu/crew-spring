package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SnNotification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.enums.NotificationChannelType;
import wiki.zex.cloud.example.resp.SnNotificationDetail;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
public interface SnNotificationMapper extends BaseMapper<SnNotification> {

    IPage<SnNotification> list(Page<SnNotification> page,
                              @Param("channelType") NotificationChannelType channelType,
                               @Param("keywords")String keywords,
                               @Param("userId")Long userId);

    SnNotificationDetail getDetailsById(@Param("id")Long id);

}
