
package com.kh021j.travelwithpleasurehub.tickets.parser.belavia.сontroller;


import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model.FlightInfo;
import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.service.JsonConverter;
import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.service.JsonService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/flights")
public class FlightInfoController {

    @ResponseBody
    @PostMapping
    public FlightInfo getFlightInfo(@RequestBody BelaviaJson belaviaJson) throws IOException {
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
