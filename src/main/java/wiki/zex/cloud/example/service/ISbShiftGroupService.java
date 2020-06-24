package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SbShiftGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbShiftGroupReq;

/**
 * <p>
 * 班次所属 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
public interface ISbShiftGroupService extends IService<SbShiftGroup> {

    SbShiftGroup create(SbShiftGroupReq req);

    SbShiftGroup update(Long id, SbShiftGroupReq req);

    void delete(Long id);

}
