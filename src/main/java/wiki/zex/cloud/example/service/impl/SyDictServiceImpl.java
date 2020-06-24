package wiki.zex.cloud.example.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.zex.cloud.example.entity.SyDict;
import wiki.zex.cloud.example.entity.SyDictEntry;
import wiki.zex.cloud.example.mapper.SyDictMapper;
import wiki.zex.cloud.example.req.SyDictReq;
import wiki.zex.cloud.example.resp.SyDictTree;
import wiki.zex.cloud.example.service.ISyDictEntryService;
import wiki.zex.cloud.example.service.ISyDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-02
 */
@Service
public class SyDictServiceImpl extends ServiceImpl<SyDictMapper, SyDict> implements ISyDictService {


    @Autowired
    private ISyDictEntryService iSyDictEntryService;
    @Override
    public SyDict create(SyDictReq req) {
        SyDict syDict = new SyDict();
        BeanUtils.copyProperties(req,syDict);
        save(syDict);
        return syDict;
    }

    @Override
    public SyDict update(Long id, SyDictReq req) {
        SyDict syDict = new SyDict();
        BeanUtils.copyProperties(req,syDict);
        syDict.setId(id);
        updateById(syDict);
        return syDict;
    }

    @Override
    public void delete(Long id) {
        SyDict syDict = getById(id);
        iSyDictEntryService.removeByDictId(syDict.getDictCode());
        removeById(id);
    }



    @Override
    public Map<String, List<SyDictEntry>> dictMap() {
        List<SyDictTree> dictTree = baseMapper.dictTree();
        Map<String, List<SyDictEntry>> map  = new HashMap<>();
        for (SyDictTree syDictTree : dictTree) {
            map.put(syDictTree.getDictCode(),syDictTree.getEntries());
        }
        return map;
    }
}
