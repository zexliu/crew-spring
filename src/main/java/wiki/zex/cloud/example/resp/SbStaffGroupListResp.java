package wiki.zex.cloud.example.resp;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.entity.SbStaffGroup;
import wiki.zex.cloud.example.entity.SbStaffTeam;

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
@ApiModel(value="SbStaffTeam对象", description="机队")
public class SbStaffGroupListResp extends SbStaffGroup {

    String leaderDescriptions;
}
