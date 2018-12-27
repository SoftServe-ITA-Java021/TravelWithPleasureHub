package com.kh021j.travelwithpleasurehub.parser.Belavia.сontroller;

import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJSON;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.PassengerQuantities;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.SearchRoutes;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.enums.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightInfoController {

    @GetMapping
    public String getFlightInfo(@ModelAttribute("price") String price,
                                @ModelAttribute("departureDate") String departureDate,
                                @ModelAttribute("arrivalDate") String arrivalDate,
                                @ModelAttribute("duration") String duration) {

        List<SearchRoutes> searchRoutes = new ArrayList<>();
        searchRoutes.add(new SearchRoutes("IEV", "BUD", "2018-12-29", 0));

        List<PassengerQuantities> passengerQuantities = new ArrayList<>();
        passengerQuantities.add(new PassengerQuantities("ADT", 1));

        BelaviaJSON belaviaJSON = new BelaviaJSON(Currency.USD, searchRoutes, passengerQuantities);
        return price;
    }
}
