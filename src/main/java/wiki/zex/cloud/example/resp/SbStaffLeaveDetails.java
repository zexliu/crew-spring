package wiki.zex.cloud.example.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.entity.SbStaffLeave;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class SbStaffLeaveDetails extends SbStaffLeave {

    private String avatar;

    private String realName;

    private List<SbStaffLeaveLogResp> logs;


}
