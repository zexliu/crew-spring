package wiki.zex.cloud.example.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.zex.cloud.example.schedule.SbAttendanceJob;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail myJobDetail(){
        return JobBuilder.newJob(SbAttendanceJob.class)
                .withIdentity("attendance")
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger myTrigger(){
        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("attendanceTrigger")
                .startNow()
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 16 * * ?"))
                .build();
    }
}