
package com.kh021j.travelwithpleasurehub.parser.airlines;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

    @Scheduled(cron = "0 0 8 * * *")
    public void reportCurrentTime() throws IOException, UnirestException {
        PopularRoutesService routes = new PopularRoutesService();
        routes.getPopularRoutes();
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
