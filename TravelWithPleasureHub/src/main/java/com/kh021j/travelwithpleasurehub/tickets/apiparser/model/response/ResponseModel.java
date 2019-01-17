package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.itineraries.Itineraries;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.legs.Legs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {
    private Carriers[] carriers;
    private Legs[] legs;
    private Itineraries[] itineraries;
    private Segments[] segments;
    private Currencies[] currencies;
    private Places[] places;
}
