package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SbRouteTable;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbRouteTableReq;

/**
 * <p>
 * 交路计划表 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
public interface ISbRouteTableService extends IService<SbRouteTable> {

    SbRouteTable create(SbRouteTableReq req);

    SbRouteTable update(Long id, SbRouteTableReq req);

    void delete(Long id);

    void updateEnable(Long id);

}
