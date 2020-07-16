package wiki.zex.cloud.example.req;

import lombok.Data;
import wiki.zex.cloud.example.enums.ExtensionFieldType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysExtensionInfoSimpleReq {

    @NotBlank
    private String fieldCode;

    @NotNull
    private ExtensionFieldType fieldType;

    private String value;

}
