package com.kh021j.travelwithpleasurehub.tickets.apiparser.service.data;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.repository.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightDataService {

    @Autowired
    FlightDataRepository flightDataRepository;
}
