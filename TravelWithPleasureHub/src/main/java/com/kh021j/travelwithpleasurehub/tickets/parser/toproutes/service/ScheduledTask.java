
package com.kh021j.travelwithpleasurehub.tickets.parser.toproutes.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0 23 * * *")
    public void reportCurrentTime() throws UnirestException {
        new TopRoutes().getMonthTopRoutes();
    }
}