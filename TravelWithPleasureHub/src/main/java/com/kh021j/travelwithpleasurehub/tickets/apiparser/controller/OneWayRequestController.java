package com.kh021j.travelwithpleasurehub.tickets.apiparser.controller;


import com.mashape.unirest.http.JsonNode;
import org.springframework.web.bind.annotation.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.RequestService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/flights/")
public class OneWayRequestController {

    @Autowired
    RequestService requestService;

    @PostMapping
    public JsonNode createRequest(@RequestBody RequestModel requestModel) throws UnirestException {

        return requestService.sendResponseToController(requestModel);
    }
}
