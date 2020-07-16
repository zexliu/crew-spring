package wiki.zex.cloud.example.mapper;

import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SysExtensionInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.req.SysExtensionInfoSimpleReq;

import java.util.List;

/**
 * <p>
 * 拓展信息值 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface SysExtensionInfoMapper extends BaseMapper<SysExtensionInfo> {


    List<SysExtensionInfo> findByInstanceId(@Param("instanceId") String instanceId);
}
