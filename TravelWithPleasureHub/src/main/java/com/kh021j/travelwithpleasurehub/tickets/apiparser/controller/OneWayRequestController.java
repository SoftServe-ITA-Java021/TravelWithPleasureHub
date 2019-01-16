package com.kh021j.travelwithpleasurehub.tickets.apiparser.controller;

import org.springframework.web.bind.annotation.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.OneWayOptionRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/flights/one-way")
public class OneWayRequestController {

    @Autowired
    OneWayOptionRequestService requestService;

    @PostMapping(produces = "application/json")
    @ResponseBody
    public String createRequest(@RequestBody RequestModel requestModel) throws UnirestException {

        return requestService.sendResponseToController(requestModel).toString();
    }
}
