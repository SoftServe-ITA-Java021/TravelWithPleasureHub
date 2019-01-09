package com.kh021j.travelwithpleasurehub.parser.Belavia;

import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.PassengerQuantities;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.SearchRoutes;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.enums.Currency;
import com.kh021j.travelwithpleasurehub.parser.Belavia.service.JsonConverter;
import com.kh021j.travelwithpleasurehub.parser.Belavia.service.JsonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BelaviaParserDemo {

    public static void main(String[] args) throws IOException {
        List<SearchRoutes> searchRoutes = new ArrayList<>();
        searchRoutes.add(new SearchRoutes("IEV", "BUD", "2019-01-20", 0));

        List<PassengerQuantities> passengerQuantities = new ArrayList<>();
        passengerQuantities.add(new PassengerQuantities("ADT", 1));

        BelaviaJson belaviaJSON = new BelaviaJson(Currency.USD, searchRoutes, passengerQuantities);

        JsonConverter jsonConverter = new JsonConverter();

        String jsonQuery = jsonConverter.objectToJson(belaviaJSON);
        System.out.println(jsonQuery);

        JsonService jsonService = new JsonService();
        String jsonBelavia = jsonService.getJsonResponse(jsonQuery);
        System.out.println(jsonBelavia);

        System.out.println(jsonService.getDepartureDateTime(jsonBelavia));
        System.out.println(jsonService.getArrivalDateTime(jsonBelavia));
        System.out.println(jsonService.getMinPriceFromResponse(jsonBelavia));
        System.out.println(jsonService.getDuration(jsonBelavia));
    }
}
