package wiki.zex.cloud.example.resp;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import wiki.zex.cloud.example.entity.SbStaff;
import wiki.zex.cloud.example.entity.SysExtensionInfo;
import wiki.zex.cloud.example.enums.GenderType;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class SbStaffDetailsResp extends SbStaff {

    @NotBlank
    @Length(min = 2, max = 10)
    private String realName;

    @Length(min = 2, max = 20)
    private String nickname;

    private String avatar;

    @NotBlank
    @Length(min = 11, max = 11)
    private String mobile;

    @Length(max = 30)
    private String workNo;

    @Length(min = 8, max = 30)
    private String email;

    private GenderType gender;

    private LocalDate birthDay;

    private List<SysExtensionInfo> extensions;


}
