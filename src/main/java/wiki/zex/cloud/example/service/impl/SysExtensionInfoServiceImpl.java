package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.zex.cloud.example.entity.SysExtensionInfo;
import wiki.zex.cloud.example.enums.ExtensionFieldType;
import wiki.zex.cloud.example.mapper.SysExtensionInfoMapper;
import wiki.zex.cloud.example.req.SysExtensionInfoSimpleReq;
import wiki.zex.cloud.example.service.ISysExtensionFieldService;
import wiki.zex.cloud.example.service.ISysExtensionInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 拓展信息值 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Service
public class SysExtensionInfoServiceImpl extends ServiceImpl<SysExtensionInfoMapper, SysExtensionInfo> implements ISysExtensionInfoService {

    @Autowired
    private ISysExtensionFieldService iSysExtensionFieldService;

    @Override
    public void removeByFieldCode(String fieldCode) {
        remove(new LambdaQueryWrapper<SysExtensionInfo>().eq(SysExtensionInfo::getFieldCode, fieldCode));
    }

    @Override
    public void updateFieldCode(String oldCode, String newCode) {
        update(new LambdaUpdateWrapper<SysExtensionInfo>()
                .set(SysExtensionInfo::getFieldCode, newCode)
                .eq(SysExtensionInfo::getFieldCode, oldCode));
    }

    @Override
    public void saveExtensions(Long id, List<SysExtensionInfoSimpleReq> extensions) {
        removeByInstanceId(id);
        if (CollectionUtils.isNotEmpty(extensions)) {
            List<SysExtensionInfo> collect = extensions.stream().map(sysExtensionInfoSimpleReq -> {
                SysExtensionInfo info = new SysExtensionInfo();
                info.setInstanceId(id);
                info.setFieldCode(sysExtensionInfoSimpleReq.getFieldCode());
                if (sysExtensionInfoSimpleReq.getFieldType() == ExtensionFieldType.TEXT_VALUE) {
                    info.setTextValue(sysExtensionInfoSimpleReq.getValue());
                } else if (sysExtensionInfoSimpleReq.getFieldType() == ExtensionFieldType.LONG_VALUE) {
                    info.setLongValue(Long.valueOf(sysExtensionInfoSimpleReq.getValue()));
                } else if (sysExtensionInfoSimpleReq.getFieldType() == ExtensionFieldType.DOUBLE_VALUE) {
                    info.setDoubleValue(Double.valueOf(sysExtensionInfoSimpleReq.getValue()));
                }
                return info;
            }).collect(Collectors.toList());
            saveBatch(collect);
        }
    }

    @Override
    public void removeByInstanceId(Long id) {
        remove(new LambdaQueryWrapper<SysExtensionInfo>().eq(SysExtensionInfo::getInstanceId, id));
    }

}
