package wiki.zex.cloud.example.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.zex.cloud.example.entity.SbRouteTable;
import wiki.zex.cloud.example.mapper.SbRouteTableMapper;
import wiki.zex.cloud.example.req.SbRouteTableReq;
import wiki.zex.cloud.example.service.ISbRouteItemService;
import wiki.zex.cloud.example.service.ISbRouteTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 交路计划表 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Service
public class SbRouteTableServiceImpl extends ServiceImpl<SbRouteTableMapper, SbRouteTable> implements ISbRouteTableService {


    @Autowired
    private ISbRouteTableService iSbRouteTableService;

    @Autowired
    private ISbRouteItemService iSbRouteItemService;
    @Override
    public SbRouteTable create(SbRouteTableReq req) {
        SbRouteTable table = new SbRouteTable();
        BeanUtils.copyProperties(req,table);
        save(table);
        return table;
    }


    @Override
    public SbRouteTable update(Long id, SbRouteTableReq req) {
        SbRouteTable table = new SbRouteTable();
        BeanUtils.copyProperties(req,table);
        table.setId(id);
        updateById(table);
        return table;
    }

    @Override
    public void delete(Long id) {
        iSbRouteItemService.removeByTableId(id);
        iSbRouteTableService.removeById(id);

    }
}
