package com.kh021j.travelwithpleasurehub.tickets.parser.toproutes;

import com.kh021j.travelwithpleasurehub.tickets.parser.toproutes.service.TopRoutes;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
    public static void main(String[] args) throws UnirestException {
        new TopRoutes().getMonthTopRoutes();
    }
}
