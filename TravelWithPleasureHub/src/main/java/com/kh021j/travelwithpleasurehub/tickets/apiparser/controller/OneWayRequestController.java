package com.kh021j.travelwithpleasurehub.tickets.apiparser.controller;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.FlightData;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.FlightDataService;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.OneWayOptionRequestService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/flights/one-way")
public class OneWayRequestController {

    @Autowired
    OneWayOptionRequestService requestService;

    @Autowired
    private FlightDataService flightDataService;

    @PostMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<FlightData>> createRequest(@RequestBody RequestModel requestModel) throws UnirestException, JSONException {
        return ResponseEntity.ok(flightDataService.getResponse(requestModel));
    }
}
