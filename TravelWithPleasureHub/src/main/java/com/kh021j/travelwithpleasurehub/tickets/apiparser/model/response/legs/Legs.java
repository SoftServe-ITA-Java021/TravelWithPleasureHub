package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.legs;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.Carriers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Legs {
    private int[] segmentsId;
    private int duration;
    private String arrival;
    private Carriers[] carriers;
    private String directionality;
    private int originStation;
    private String departure;
    private FlightNumber[] flightNumbers;
    private String jorneyMode;
    private int destinationStation;
    private int[] stops;
    private int[] operatingCarriers;
    private String id;
}
