package wiki.zex.cloud.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import wiki.zex.cloud.example.entity.SbRuntimeTable;
import wiki.zex.cloud.example.entity.SbRuntimeTableDate;
import wiki.zex.cloud.example.exception.ParameterException;
import wiki.zex.cloud.example.mapper.SbRuntimeTableDateMapper;
import wiki.zex.cloud.example.req.RuntimeTableDateGenerateReq;
import wiki.zex.cloud.example.req.SbRuntimeTableDateReq;
import wiki.zex.cloud.example.req.SbRuntimeTableReq;
import wiki.zex.cloud.example.service.ISbRuntimeTableDateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 时刻表对应日期 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-17
 */
@Service
public class SbRuntimeTableDateServiceImpl extends ServiceImpl<SbRuntimeTableDateMapper, SbRuntimeTableDate> implements ISbRuntimeTableDateService {


    @Override
    @Transactional
    public void generate(RuntimeTableDateGenerateReq req) {
        if (req.getStartAt().isAfter(req.getEndAt())) {
            throw new ParameterException("开始时间不得小于结束时间");
        }

        List<SbRuntimeTableDate> tableDates = new ArrayList<>();
        for (int i = 0; i <= Period.between(req.getStartAt(), req.getEndAt()).getDays(); i++) {
            LocalDate date = req.getStartAt().plusDays(i);
            SbRuntimeTableDate tableDate = new SbRuntimeTableDate();
            tableDate.setDate(date);
            tableDate.setTableId(req.getGenerateRules().get(date.getDayOfWeek()));
            tableDates.add(tableDate);
        }
        //删除以前生成的数据
        remove(new LambdaQueryWrapper<SbRuntimeTableDate>()
                .ge(SbRuntimeTableDate::getDate, req.getStartAt())
                .le(SbRuntimeTableDate::getDate, req.getEndAt()));
        saveBatch(tableDates);
    }

    @Override
    public SbRuntimeTableDate update(Long id, SbRuntimeTableDateReq req) {
        SbRuntimeTableDate table = new SbRuntimeTableDate();
        BeanUtils.copyProperties(req,table);
        table.setId(id);
        updateById(table);
        return table;
    }

    @Override
    public void removeByTableId(Long id) {
        remove(new LambdaQueryWrapper<SbRuntimeTableDate>().eq(SbRuntimeTableDate::getTableId,id));
    }

}
