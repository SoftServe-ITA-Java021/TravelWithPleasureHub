
package com.kh021j.travelwithpleasurehub.parser.belavia.service;

import com.kh021j.travelwithpleasurehub.parser.belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.FlightInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FlightInfoService {

    private static final Logger logger = LoggerFactory.getLogger(FlightInfoService.class);

    //@Cacheable(cacheNames = "flightinfo")
    public FlightInfo createFlightInfo(BelaviaJson belaviaJson) throws IOException {
        final FlightInfo flightInfo = getFlightInfo(belaviaJson);
        logger.info("Cache " + flightInfo.toString());
        return flightInfo;
    }

    //@CachePut(cacheNames = "flightinfo")
    public FlightInfo createFlightInfoAndPut(BelaviaJson belaviaJson) throws IOException {
        final FlightInfo flightInfo = getFlightInfo(belaviaJson);
        return flightInfo;
    }

    private FlightInfo getFlightInfo(BelaviaJson belaviaJson) throws IOException {
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
