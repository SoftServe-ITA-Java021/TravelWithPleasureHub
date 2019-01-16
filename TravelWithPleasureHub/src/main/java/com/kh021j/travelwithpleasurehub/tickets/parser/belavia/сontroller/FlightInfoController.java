package com.kh021j.travelwithpleasurehub.tickets.parser.belavia.сontroller;

import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model.FlightInfo;
import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.service.FlightInfoService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("flights")
public class FlightInfoController {

    @ResponseBody
    @PostMapping
    public FlightInfo getFlightInfo(@RequestBody BelaviaJson belaviaJson) throws IOException {
        return new FlightInfoService().createFlightInfo(belaviaJson);
    }
}
