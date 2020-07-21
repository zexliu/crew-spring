package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbSafeConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SbSafeConfigResp;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-07-20
 */
public interface SbSafeConfigMapper extends BaseMapper<SbSafeConfig> {

    IPage<SbSafeConfigResp> list(Page<SbSafeConfigResp> page, @Param("type") Integer type);
}
