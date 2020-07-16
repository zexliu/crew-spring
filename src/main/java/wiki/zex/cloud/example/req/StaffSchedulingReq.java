package wiki.zex.cloud.example.req;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StaffSchedulingReq {

    private LocalDate startAt;

    private LocalDate endAt;
}
