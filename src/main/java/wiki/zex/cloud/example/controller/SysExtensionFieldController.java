package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SysExtensionField;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SysExtensionFieldReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISysExtensionFieldService;

import javax.validation.Valid;

/**
 * <p>
 * 拓展信息字段 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/api/v1/extension/field")
@Api(tags = "拓展信息字段")
public class SysExtensionFieldController {

    @Autowired
    private ISysExtensionFieldService iSysExtensionFieldService;

    @GetMapping
    public IPage<SysExtensionField> page(Pageable pageable, String tableName) {
        return iSysExtensionFieldService.page(pageable.convert(), new LambdaQueryWrapper<SysExtensionField>()
                .eq(StringUtils.isNotBlank(tableName), SysExtensionField::getTableName, tableName));
    }

    @PostMapping
    public SysExtensionField create(@Valid @RequestBody SysExtensionFieldReq req) {
        return iSysExtensionFieldService.create(req);
    }

    @PutMapping("/{id}")
    public SysExtensionField update(@PathVariable Long id, @Valid @RequestBody SysExtensionFieldReq req) {

        return iSysExtensionFieldService.update(req, id);
    }


    @GetMapping("/{id}")
    public SysExtensionField getById(@PathVariable Long id) {
        return iSysExtensionFieldService.getById(id);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id) {
        iSysExtensionFieldService.delete(id);
        return SimpleResp.SUCCESS;
    }

}
