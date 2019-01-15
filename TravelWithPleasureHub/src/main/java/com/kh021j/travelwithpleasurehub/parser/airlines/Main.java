package com.kh021j.travelwithpleasurehub.parser.airlines;

import com.kh021j.travelwithpleasurehub.parser.airlines.service.PopularRoutesService;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, UnirestException {
        System.out.println(new PopularRoutesService().getPopularRoutes());
    }
}
