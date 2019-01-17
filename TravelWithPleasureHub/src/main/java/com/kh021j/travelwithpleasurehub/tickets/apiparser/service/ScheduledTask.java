
package com.kh021j.travelwithpleasurehub.tickets.apiparser.service;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.Flight;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.repository.FlightRepository;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class ScheduledTask {
    @Autowired
    private FlightRepository flightRepository;

    @Scheduled(cron = "0 0 23 * * *")
    public void reportCurrentTime() throws UnirestException, JSONException {
        TopRoutes.getMonthTopRoutes();
    }

    @Scheduled(cron = "0 1 1 ? * *")
    public void deleteOldData() {
        for (Flight flight : flightRepository.findAll()) {
            if (flight.getArrivalTime().isAfter(ZonedDateTime.now())) {
                flightRepository.delete(flight);
            }
        }
    }
}
