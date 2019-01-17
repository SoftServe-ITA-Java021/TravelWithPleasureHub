package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Segments {
    private String directionality;
    private int originStation;
    private String departureDateTime;
    private String arrivalDateTime;
    private String journeyMode;
    private int destinationStation;
    private int operatingCarrier;
    private String flightNumber;
    private int duration;
    private int id;
    private int carrier;
}
