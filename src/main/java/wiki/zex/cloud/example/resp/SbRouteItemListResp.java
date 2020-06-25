package wiki.zex.cloud.example.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.config.serializers.JsonLongSerializer;
import wiki.zex.cloud.example.entity.SbRouteItem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
public class SbRouteItemListResp extends SbRouteItem {

    private String trainNoDescriptions;

    private  String backTrainNo;

    private String meetTrainNo;

}
