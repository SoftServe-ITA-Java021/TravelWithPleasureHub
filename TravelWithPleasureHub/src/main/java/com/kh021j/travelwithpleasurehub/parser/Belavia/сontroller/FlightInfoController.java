package com.kh021j.travelwithpleasurehub.parser.Belavia.сontroller;

import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.FlightInfo;
import com.kh021j.travelwithpleasurehub.parser.Belavia.service.JsonConverter;
import com.kh021j.travelwithpleasurehub.parser.Belavia.service.JsonService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("flights")
public class FlightInfoController {

    @ResponseBody
    @PostMapping
    public FlightInfo getFlightInfo(@RequestBody BelaviaJson belaviaJson) throws IOException {
        if (belaviaJson == null || belaviaJson.toString().equals("{}")) {
            return new FlightInfo();
        }

        String jsonQuery = new JsonConverter().objectToJson(belaviaJson);
        JsonService jsonService = new JsonService();
        String jsonBelavia = jsonService.getJsonResponse(jsonQuery);

        return new FlightInfo(jsonService.getMinPriceFromResponse(jsonBelavia),
                belaviaJson.getCurrency(), jsonService.getDepartureDateTime(jsonBelavia),
                jsonService.getArrivalDateTime(jsonBelavia), jsonService.getDuration(jsonBelavia),
                belaviaJson.getSearchRoutes().get(0).getOrigin(),
                belaviaJson.getSearchRoutes().get(0).getDestination());
    }
}
