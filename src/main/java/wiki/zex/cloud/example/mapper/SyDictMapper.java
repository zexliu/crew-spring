package wiki.zex.cloud.example.mapper;

import wiki.zex.cloud.example.entity.SyDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SyDictTree;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-06-02
 */
public interface SyDictMapper extends BaseMapper<SyDict> {

    List<SyDictTree> dictTree();

}
