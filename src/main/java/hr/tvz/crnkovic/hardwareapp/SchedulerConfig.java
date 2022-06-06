package hr.tvz.crnkovic.hardwareapp;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(InfoJob.class).withIdentity("infoJob").storeDurably().build();
    }

    @Bean
    public Trigger jobTrigger(){
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity("infoJob")
                .withSchedule(simpleScheduleBuilder).build();
    }


}
