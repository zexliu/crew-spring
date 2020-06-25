package wiki.zex.cloud.example.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;
import wiki.zex.cloud.example.entity.SbRouteItem;
import wiki.zex.cloud.example.entity.SbRuntimeItem;

import java.util.List;

/**
 * <p>
 * 交路计划明细表
 * </p>
 *
 * @author Zex
 * @since 2020-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SbRouteItem对象", description="交路计划明细表")
public class SbRouteItemDetailsResp extends SbRouteItem {

    private List<SbRuntimeItem> runtimeItems;

    private SbRuntimeItem meetRuntimeItem;
    private SbRuntimeItem backRuntimeItem;
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long runtimeTableId;

}
