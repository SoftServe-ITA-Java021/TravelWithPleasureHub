package com.kh021j.travelwithpleasurehub;

import com.kh021j.travelwithpleasurehub.propertyrent.service.ImgurAPIService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TravelwithpleasurehubApplication {
    public static void main(String[] args) {
        SpringApplication.run(TravelwithpleasurehubApplication.class, args);
        ImgurAPIService.getToken();
    }
}
