package wiki.zex.cloud.example.resp;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.config.excel.GenderConverter;
import wiki.zex.cloud.example.entity.SbStaff;
import wiki.zex.cloud.example.enums.GenderType;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
public class SbStaffResp extends SbStaff {

    @ApiModelProperty(value = "手机号码")
    @ExcelProperty("手机号码")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    @ExcelProperty("邮箱")
    private String email;


    @ApiModelProperty(value = "真实姓名")
    @ExcelProperty("真实姓名")
    private String realName;

    @ApiModelProperty(value = "头像")
    @ExcelProperty("头像")
    private String avatar;

    @ApiModelProperty(value = "工号")
    @ExcelProperty("工号")
    private String workNo;

    @ApiModelProperty(value = "性别")
    @ExcelProperty(value = "性别",converter = GenderConverter.class)
    private GenderType gender;

    @ApiModelProperty(value = "生日")
    @ExcelIgnore
    private LocalDate birthDay;




}
