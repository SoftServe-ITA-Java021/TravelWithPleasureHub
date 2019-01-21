/*
package com.kh021j.travelwithpleasurehub.tickets.apiparser.service;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.FlightData;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TopRoutesThread implements Runnable {
    private static int startRange;
    private static int endRange;
    private static int threadsAmount;
    private static int range;
    private static int rangeFinal;
    private String name;

    private static Date currentDate = new Date();
    private static List<RequestModel> list = TopRoutes.getTopRoutes();

    public TopRoutesThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        getData();
    }

    public void getData() {
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        List<FlightData> flightDataList = new ArrayList<>();

        for (int i = startRange; i < range && i < list.size(); i++) {
            if
            RequestModel requestModel = list.get(i);
            for (int j = 1; j < 31; j++) {
                System.out.println(localDate.plusDays(j).toString());
                requestModel.setOutboundDate(localDate.plusDays(j).toString());
                try {
                    System.out.println(TopRoutes.getFlightsData(requestModel));
                    flightDataList.addAll(TopRoutes.getFlightsData(requestModel));
                } catch (JSONException | UnirestException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createThreads() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new TopRoutesThread("First"));
        executorService.execute(new TopRoutesThread("Second"));
        executorService.execute(new TopRoutesThread("Third"));
    }
}
*/
