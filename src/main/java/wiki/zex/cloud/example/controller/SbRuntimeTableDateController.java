package wiki.zex.cloud.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiki.zex.cloud.example.entity.SbRuntimeTableDate;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.RuntimeTableDateGenerateReq;
import wiki.zex.cloud.example.req.SbRuntimeTableDateReq;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbRuntimeTableDateService;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * <p>
 * 时刻表对应日期 前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-17
 */

@Api(tags = "时刻表对应日期")
@RestController
@RequestMapping("/api/v1/runtime/table/dates")
public class SbRuntimeTableDateController {
    @Autowired
    private ISbRuntimeTableDateService iSbRuntimeTableDateService;

    @GetMapping
    public IPage<SbRuntimeTableDate> list(Pageable pageable, @RequestParam String month) {
        TemporalAccessor temporalAccessor = DateTimeFormatter.ofPattern("yyyy-MM").parse(month);
        LocalDate date = LocalDate.of(temporalAccessor.get(ChronoField.YEAR),temporalAccessor.get(ChronoField.MONTH_OF_YEAR),1);
        return iSbRuntimeTableDateService.page(pageable.convert(),
                new LambdaQueryWrapper<SbRuntimeTableDate>()
                        .between(SbRuntimeTableDate::getDate,date.minusDays(6),date.plusDays(44))
                        .orderByAsc(SbRuntimeTableDate::getDate));
    }
    @PostMapping("/gen")
    public SimpleResp generate(@Valid @RequestBody RuntimeTableDateGenerateReq req) {
        iSbRuntimeTableDateService.generate(req);
        return SimpleResp.SUCCESS;
    }


    @PutMapping("/{id}")
    public SbRuntimeTableDate update(@PathVariable Long id, @Valid @RequestBody SbRuntimeTableDateReq req) {
        return iSbRuntimeTableDateService.update(id, req);
    }

}
