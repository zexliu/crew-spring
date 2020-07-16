package wiki.zex.cloud.example.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import wiki.zex.cloud.example.entity.*;
import wiki.zex.cloud.example.exception.ParameterException;
import wiki.zex.cloud.example.mapper.SbRouteItemMapper;
import wiki.zex.cloud.example.req.SbRouteItemReq;
import wiki.zex.cloud.example.resp.SbRouteItemDetailsResp;
import wiki.zex.cloud.example.resp.SbRouteItemListResp;
import wiki.zex.cloud.example.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

import static wiki.zex.cloud.example.config.ConverterConfig.DEFAULT_TIME_FORMAT;

/**
 * <p>
 * 交路计划明细表 服务实现类
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
@Service
@Slf4j
public class SbRouteItemServiceImpl extends ServiceImpl<SbRouteItemMapper, SbRouteItem> implements ISbRouteItemService, IExcelService {


    @Autowired
    private ISbStationService iSbStationService;
    @Autowired
    private ISbRouteRuntimeRelService iSbRouteRuntimeRelService;

    @Autowired
    private ISbRuntimeItemService iSbRuntimeItemService;

    @Autowired
    private ISbShiftGroupService iSbShiftGroupService;


    @Autowired
    private ISbRouteTableService iSbRouteTableService;
    @Override
    public void removeByTableId(Long id) {
        remove(new LambdaQueryWrapper<SbRouteItem>().eq(SbRouteItem::getTableId, id));

    }

    @Override
    public SbRouteItem create(SbRouteItemReq req) {
        SbRouteItem item = new SbRouteItem();
        BeanUtils.copyProperties(req, item);
        save(item);
        iSbRouteRuntimeRelService.updateRelations(item.getId(), req.getRuntimeItemIds());
        return item;
    }

    @Override
    public SbRouteItem update(Long id, SbRouteItemReq req) {
        SbRouteItem item = new SbRouteItem();
        BeanUtils.copyProperties(req, item);
        item.setId(id);
        updateById(item);
        return item;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iSbRouteRuntimeRelService.removeByRouteItemId(id);
        removeById(id);
    }

    @Override
    public SbRouteItemDetailsResp getDetails(Long id) {
        return baseMapper.getDetails(id);
    }

    @Override
    public IPage<SbRouteItemListResp> list(Page<SbRouteItemListResp> page, Long tableId, Long shiftId, String routeItemNo, Long attendanceStationId, String meetTrainNo, Long meetStationId, String backTrainNo, Long backStationId) {
        return baseMapper.page(page, tableId, shiftId, routeItemNo, attendanceStationId, meetTrainNo, meetStationId, backTrainNo, backStationId);
    }

    @Override
    public List<SbRouteItem> listByDateAndShiftGroupId(LocalDate curDate, Long shiftGroupId) {
        return baseMapper.listByDateAndShiftGroupId(curDate,shiftGroupId);
    }


    @Override
    public void download(HttpServletResponse httpServletResponse) {

    }

    @Override
    @Transactional
    public void upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String tableIdStr = request.getParameter("tableId");
        Long tableId = Long.valueOf(tableIdStr);
        SbRouteTable routeTable = iSbRouteTableService.getById(tableId);
        List<SbStation> list = iSbStationService.list();

        EasyExcel.read(file.getInputStream(), new AnalysisEventListener<Map<Integer, String>>() {

            final List<SbRouteItemReq> reqs = new ArrayList<>();

            @Override
            public void invoke(Map<Integer, String> data, AnalysisContext context) {
                SbRouteItemReq req = new SbRouteItemReq();
                log.info("Data = {}",data);
                if (data.get(0) == null || data.get(0).contains("交路")) {
                    return;
                }
                SbShiftGroup group = null;
                if (data.get(0).contains("早")) {
                    group = iSbShiftGroupService.getByName("早班");
                } else if (data.get(0).contains("白")) {
                    group = iSbShiftGroupService.getByName("白班");
                } else if (data.get(0).contains("夜")) {
                    group = iSbShiftGroupService.getByName("夜班");
                }
                if (group == null) {
                    throw new ParameterException("班次组不存在");
                }
                if (data.get(0).contains("早")){
                    req.setTableId(tableId);
                    req.setShiftGroupId(group.getId());
                    req.setRouteItemNo(data.get(0));  //班次处理
                    SbStation attendanceStation = findStation(list, data.get(1));
                    req.setAttendanceStationId(attendanceStation.getId());
                    req.setAttendanceAt(formatTime(data.get(2)));
                    SbRuntimeItem meetRuntimeItem = iSbRuntimeItemService.getByTrainNo(routeTable.getRuntimeTableId(),data.get(3));
                    req.setMeetRuntimeItemId(meetRuntimeItem.getId());
                    req.setMeetAt(formatTime(data.get(4)));
                    String[] trainNos = data.get(5).split("--->");
                    if (trainNos[trainNos.length - 1].length() > 6) {
                        trainNos[trainNos.length - 1] = trainNos[trainNos.length - 1].substring(0, 6);
                    }
                    List<Long> runtimeIds = iSbRuntimeItemService.getRuntimeIdsByTrainNos(Arrays.asList(trainNos));
                    req.setRuntimeItemIds(runtimeIds);

                    SbRuntimeItem backRuntimeItem = iSbRuntimeItemService.getByTrainNo(routeTable.getRuntimeTableId(), data.get(6));
                    req.setBackRuntimeItemId(backRuntimeItem.getId());
                    SbStation backStation = findStation(list, data.get(7));
                    req.setBackStationId(backStation.getId());
                    req.setBackAt(formatTime(data.get(8)));
                    req.setDistance(Double.parseDouble(data.get(9)));
                    req.setDescription(data.get(10));
                    req.setRemark(data.get(11));
                    reqs.add(req);
                }else{
                    req.setTableId(tableId);
                    req.setShiftGroupId(group.getId());
                    req.setRouteItemNo(data.get(0));  //班次处理
                    SbStation attendanceStation = findStation(list, data.get(1));
                    req.setAttendanceStationId(attendanceStation.getId());
                    req.setAttendanceAt(formatTime(data.get(2)));
                    req.setMeetAt(formatTime(data.get(3)));
                    SbRuntimeItem meetRuntimeItem = iSbRuntimeItemService.getByTrainNo(routeTable.getRuntimeTableId(), data.get(4));
                    req.setMeetRuntimeItemId(meetRuntimeItem.getId());
                    SbStation meetStation = findStation(list, data.get(5));
                    req.setMeetStationId(meetStation.getId());
                    String[] trainNos = data.get(6).split("--->");
                    if (trainNos[trainNos.length - 1].length() > 6) {
                        trainNos[trainNos.length - 1] = trainNos[trainNos.length - 1].substring(0, 6);
                    }
                    List<Long> runtimeIds = iSbRuntimeItemService.getRuntimeIdsByTrainNos(Arrays.asList(trainNos));
                    req.setRuntimeItemIds(runtimeIds);
                    SbRuntimeItem backRuntimeItem = iSbRuntimeItemService.getByTrainNo(routeTable.getRuntimeTableId(), data.get(7));
                    req.setBackRuntimeItemId(backRuntimeItem.getId());
                    SbStation backStation = findStation(list, data.get(8));
                    req.setBackStationId(backStation.getId());
                    req.setBackAt(formatTime(data.get(9)));
                    req.setDistance(Double.parseDouble(data.get(10)));
                    req.setDescription(data.get(11));
                    req.setRemark(data.get(12));
                    reqs.add(req);
                }

            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData(reqs);
            }
        }).sheet().doRead();
    }

    private void saveData(List<SbRouteItemReq> reqs) {
        for (SbRouteItemReq req : reqs) {
            create(req);
        }
        reqs.clear();
    }

    private LocalTime formatTime(String time) {
        if (time.length() == 7) {
            time = "0" + time;
        }
        return LocalTime.parse(time, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
    }

    private SbStation findStation(List<SbStation> list, String s) {
        s = s.replaceAll("\n","").trim();
        String finalS = s;
        Optional<SbStation> optionalSbStation = list.stream().filter(new Predicate<SbStation>() {
            @Override
            public boolean test(SbStation sbStation) {
                return StringUtils.contains(finalS, sbStation.getStationName());
            }
        }).findFirst();

        if (optionalSbStation.isPresent()) {
            return optionalSbStation.get();
        }
        throw new ParameterException("未找到可用车站 "+s);
    }
}
