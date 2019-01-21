package com.kh021j.travelwithpleasurehub.tickets;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.TopRoutes;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) throws JSONException, UnirestException {
        TopRoutes.getMonthTopRoutes();

        /*Thread thread = new Thread(new TopRoutesThread());
        Thread thread2 = new Thread(new TopRoutesThread());
           thread.start();
           thread2.start();*/
    }
}
