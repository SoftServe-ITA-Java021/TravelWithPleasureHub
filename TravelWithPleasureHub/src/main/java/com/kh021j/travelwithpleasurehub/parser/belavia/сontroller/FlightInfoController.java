package com.kh021j.travelwithpleasurehub.parser.belavia.сontroller;

import com.kh021j.travelwithpleasurehub.parser.belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.FlightInfo;
import com.kh021j.travelwithpleasurehub.parser.belavia.service.FlightInfoService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("api/flights")
public class FlightInfoController {

    @ResponseBody
    @PostMapping
    public FlightInfo getFlightInfo(@RequestBody BelaviaJson belaviaJson) throws IOException {
        return new FlightInfoService().createFlightInfo(belaviaJson);
    }
}
