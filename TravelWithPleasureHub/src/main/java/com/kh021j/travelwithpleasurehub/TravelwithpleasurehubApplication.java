package com.kh021j.travelwithpleasurehub;

import com.kh021j.travelwithpleasurehub.propertyrent.service.ImgurAPIService;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.TopRoutes;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TravelwithpleasurehubApplication {
    public static void main(String[] args) throws JSONException, UnirestException {
        SpringApplication.run(TravelwithpleasurehubApplication.class, args);
        ImgurAPIService.getToken();
        TopRoutes.getMonthTopRoutes();
    }
}
