package wiki.zex.cloud.example.mapper;

import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SyDictEntry;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典项 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-06-02
 */
public interface SyDictEntryMapper extends BaseMapper<SyDictEntry> {

    List<SyDictEntry> findByDictCode(@Param("dictCode") String dictCode);
}
