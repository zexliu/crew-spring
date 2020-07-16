package wiki.zex.cloud.example.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.entity.SbStaffAttendance;

@Data
@EqualsAndHashCode(callSuper = false)
public class SbStaffAttendanceResp extends SbStaffAttendance {

    private String avatar;

    private String realName;

}
