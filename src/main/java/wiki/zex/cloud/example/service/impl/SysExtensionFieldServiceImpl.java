package wiki.zex.cloud.example.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wiki.zex.cloud.example.entity.SysExtensionField;
import wiki.zex.cloud.example.mapper.SysExtensionFieldMapper;
import wiki.zex.cloud.example.req.SysExtensionFieldReq;
import wiki.zex.cloud.example.service.ISysExtensionFieldService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wiki.zex.cloud.example.service.ISysExtensionInfoService;

/**
 * <p>
 * 拓展信息字段 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Service
public class SysExtensionFieldServiceImpl extends ServiceImpl<SysExtensionFieldMapper, SysExtensionField> implements ISysExtensionFieldService {

    @Autowired
    private ISysExtensionInfoService iSysExtensionInfoService;
    @Override
    public SysExtensionField create(SysExtensionFieldReq req) {
        SysExtensionField field = new SysExtensionField();
        BeanUtils.copyProperties(req,field);
        save(field);
        return field;
    }

    @Override
    @Transactional
    public SysExtensionField update(SysExtensionFieldReq req, Long id) {
        SysExtensionField field = getById(id);
        if (!StringUtils.equals(field.getFieldCode(),req.getFieldCode())){
            iSysExtensionInfoService.updateFieldCode(field.getFieldCode(),req.getFieldCode());
        }
        BeanUtils.copyProperties(req,field);
        field.setId(id);
        updateById(field);
        return field;
    }

    @Override
    public void delete(Long id) {
        SysExtensionField field = getById(id);
        if (field != null){
            iSysExtensionInfoService.removeByFieldCode(field.getFieldCode());
            removeById(id);
        }

    }
}
