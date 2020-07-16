package wiki.zex.cloud.example.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.config.serializers.JsonListLongSerializer;
import wiki.zex.cloud.example.entity.SbStaffGroup;
import wiki.zex.cloud.example.entity.SbStaffTeam;

import java.util.List;

/**
 * <p>
 * 机队
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SbStaffGroup对象", description = "机组")
public class SbStaffGroupResp extends SbStaffGroup {

    @JsonSerialize(using = JsonListLongSerializer.class)
    private List<Long> leaderIds;
}
