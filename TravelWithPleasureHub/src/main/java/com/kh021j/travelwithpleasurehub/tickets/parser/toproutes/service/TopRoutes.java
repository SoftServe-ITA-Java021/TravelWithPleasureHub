
package com.kh021j.travelwithpleasurehub.tickets.parser.toproutes.service;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.OneWayOptionRequestService;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TopRoutes {

    private static Date currentDate = new Date();

    public List<String> getMonthTopRoutes() throws UnirestException {
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        List<RequestModel> list = getTopRoutes();
        List<String> listInfo = new ArrayList<>();

        OneWayOptionRequestService oneWayOptionRequestService =
                new OneWayOptionRequestService();
        for (RequestModel entity : list) {
            for (int i = 0; i < 30; i++) {
                entity.setOutboundDate(localDate.plusDays(i).toString());
                listInfo.add(oneWayOptionRequestService.sendResponseToController(entity).toString());
            }
        }
        return listInfo;
    }

    public List<RequestModel> getTopRoutes() {
        List<RequestModel> list = new ArrayList<>();
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.add(new RequestModel("US", "USD", "en-US",
                        "ICN", "CJU", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "MEL", "SYD", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "BOM", "DEL", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "DUB", "LON", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "RIO", "GRU", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "LAX", "SFO", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "SIN", "KUL", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "LGA", "YYZ", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "AMS", "LHR", localDate.toString(),
                        i, "economy", j, 0));
                list.add(new RequestModel("US", "USD", "en-US",
                        "DXB", "KWI", localDate.toString(),
                        i, "economy", j, 0));
            }
        }
        return list;
    }
}
