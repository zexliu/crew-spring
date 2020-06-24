package wiki.zex.cloud.example.service;

import wiki.zex.cloud.example.entity.SbRuntimeTableDate;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zex.cloud.example.req.RuntimeTableDateGenerateReq;
import wiki.zex.cloud.example.req.SbRuntimeTableDateReq;
import wiki.zex.cloud.example.req.SbRuntimeTableReq;

import javax.validation.Valid;

/**
 * <p>
 * 时刻表对应日期 服务类
 * </p>
 *
 * @author Zex
 * @since 2020-06-17
 */
public interface ISbRuntimeTableDateService extends IService<SbRuntimeTableDate> {

    void generate(RuntimeTableDateGenerateReq req);

    SbRuntimeTableDate update(Long id,  SbRuntimeTableDateReq req);

    void removeByTableId(Long id);
}
