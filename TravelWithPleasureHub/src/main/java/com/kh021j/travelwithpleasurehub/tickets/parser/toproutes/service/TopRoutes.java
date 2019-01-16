
package com.kh021j.travelwithpleasurehub.tickets.parser.toproutes.service;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.OneWayOptionRequestService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TopRoutes {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    private static Date currentDate = new Date();

    public List<RequestModel> getMonthTopRoutes() throws UnirestException {
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        List<RequestModel> list = getTopRoutes();
        System.out.println(list);

        OneWayOptionRequestService oneWayOptionRequestService = new OneWayOptionRequestService();
        for(RequestModel entity: list){

                /*entity.setOutboundDate(localDate.plusDays(i).toString());
                System.out.println(entity);*/
                oneWayOptionRequestService.sendResponseToController(entity);

        }
        return new ArrayList<>();
    }

    public List<RequestModel> getTopRoutes(){
        List<RequestModel> list = new ArrayList<>();
        list.add(new RequestModel("US", "USD", "en-US",
                "KBP", "MSQ", dateFormat.format(currentDate),
                1, "economy", 0, 0));
        return list;
    }
}
