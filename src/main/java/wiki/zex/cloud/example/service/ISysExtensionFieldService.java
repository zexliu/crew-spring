package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SysExtensionField;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SysExtensionFieldReq;

/**
 * <p>
 * 拓展信息字段 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface ISysExtensionFieldService extends IService<SysExtensionField> {

    SysExtensionField create(SysExtensionFieldReq req);

    SysExtensionField update(SysExtensionFieldReq req, Long id);

    void delete(Long id);

}
