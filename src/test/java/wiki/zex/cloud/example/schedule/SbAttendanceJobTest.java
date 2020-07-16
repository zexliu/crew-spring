package wiki.zex.cloud.example.schedule;

import org.junit.jupiter.api.Test;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.zex.cloud.example.ExampleApplicationTests;

import static org.junit.jupiter.api.Assertions.*;

class SbAttendanceJobTest extends ExampleApplicationTests {

    @Autowired
    private SbAttendanceJob sbAttendanceJob;
    @Test
    void executeInternal() throws JobExecutionException {
        sbAttendanceJob.executeInternal(null);
    }
}