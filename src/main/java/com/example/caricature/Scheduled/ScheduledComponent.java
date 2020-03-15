package com.example.caricature.Scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ScheduledComponent {
    @Scheduled(cron = "0/5 * * * * ? ")
    public void wxPolling() {
//    log.info("我打印了");
    }
}
