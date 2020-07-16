package wiki.zex.cloud.example.mapper;

import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SnNotificationUserRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.entity.SyUser;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-07-15
 */
public interface SnNotificationUserRelMapper extends BaseMapper<SnNotificationUserRel> {

    List<SyUser> selectUsersByNotificationId(@Param("notificationId") Long notificationId );

}
