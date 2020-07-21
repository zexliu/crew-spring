package wiki.zex.cloud.example.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.entity.SbStaffLeaveLog;

@Data
@EqualsAndHashCode(callSuper = false)
public class SbStaffLeaveLogResp extends SbStaffLeaveLog {
    private String avatar;

    private String realName;
}
