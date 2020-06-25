package wiki.zex.cloud.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import wiki.zex.cloud.example.entity.SbRouteItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wiki.zex.cloud.example.resp.SbRouteItemDetailsResp;
import wiki.zex.cloud.example.resp.SbRouteItemListResp;

/**
 * <p>
 * 交路计划明细表 Mapper 接口
 * </p>
 *
 * @author Zex
 * @since 2020-06-22
 */
public interface SbRouteItemMapper extends BaseMapper<SbRouteItem> {

    IPage<SbRouteItemListResp> page(Page<SbRouteItemListResp> page,
                                    @Param("tableId") Long tableId,
                                    @Param("shiftId")Long shiftId,
                                    @Param("routeItemNo")String routeItemNo,
                                    @Param("attendanceStationId")Long attendanceStationId,
                                    @Param("meetTrainNo")String meetTrainNo,
                                    @Param("meetStationId")Long meetStationId,
                                    @Param("backTrainNo")String backTrainNo,
                                    @Param("backStationId")Long backStationId);


    SbRouteItemDetailsResp getDetails(@Param("id")Long id);
}
