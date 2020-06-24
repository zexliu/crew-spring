package wiki.zex.cloud.example.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SbRuntimeTableDateReq {

    @NotNull
    Long tableId;

}
