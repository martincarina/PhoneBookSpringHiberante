package ru.academits.shedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 10000)
    public void sendEmailWithContactList(){
        System.out.println("schedule");
    }
}
