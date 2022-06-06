package hr.tvz.crnkovic.hardwareapp;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

@Slf4j
public class InfoJob extends QuartzJobBean {

    @Autowired
    private JdbcHardwareRepository hardwareRepository;

    private String name;

    private void setName(String name){
        this.name=name;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<Hardware> hardwares = hardwareRepository.findAll();
        log.info("Trenutno dostupni hardveri:");

        log.info("---------------------------");
        for(Hardware hardware : hardwares) {
            if (hardware.getStock() > 0) {
                log.info(hardware.getName()+" - "+hardware.getStock());
            }
        }
        log.info("---------------------------");
    }


}
