package com.kh021j.travelwithpleasurehub.parser.Belavia.сontroller;

import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.PassengerQuantities;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.SearchRoutes;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.enums.Currency;
import com.kh021j.travelwithpleasurehub.parser.Belavia.service.JsonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightInfoController {

    @GetMapping
    public String getFlightInfo() throws IOException {

        List<SearchRoutes> searchRoutes = new ArrayList<>();
        searchRoutes.add(new SearchRoutes("IEV", "BUD", "2019-01-20", 0));

        List<PassengerQuantities> passengerQuantities = new ArrayList<>();
        passengerQuantities.add(new PassengerQuantities("ADT", 1));

        BelaviaJson belaviaJSON = new BelaviaJson(Currency.USD, searchRoutes, passengerQuantities);
        JsonService jsonService = new JsonService();
        return jsonService.getMinPriceFromResponse(jsonService.getJsonResponse(belaviaJSON.toString()));
    }
}
