package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SysExtensionInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.SysExtensionInfoSimpleReq;

import java.util.List;

/**
 * <p>
 * 拓展信息值 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
public interface ISysExtensionInfoService extends IService<SysExtensionInfo> {


    void saveExtensions(Long id, List<SysExtensionInfoSimpleReq> extensions);
    void removeByInstanceId(Long id);
    void removeByFieldCode(String fieldCode);

    void updateFieldCode(String oldCode, String newCode);
}
