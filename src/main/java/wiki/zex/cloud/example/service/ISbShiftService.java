package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SbShift;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SbShiftReq;

/**
 * <p>
 * 班次 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
public interface ISbShiftService extends IService<SbShift> {

    void removeByGroupId(Long id);

    SbShift create(SbShiftReq req);

    SbShift update(Long id, SbShiftReq req);

    void delete(Long id);

}
