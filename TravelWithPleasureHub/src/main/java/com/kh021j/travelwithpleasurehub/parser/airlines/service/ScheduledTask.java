
package com.kh021j.travelwithpleasurehub.parser.airlines.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0 22 * * *")
    public void reportCurrentTime() throws IOException, UnirestException {
        new PopularRoutesService().getPopularRoutes();
    }
}
