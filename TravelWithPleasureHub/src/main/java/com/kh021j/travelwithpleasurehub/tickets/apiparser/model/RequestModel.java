package com.kh021j.travelwithpleasurehub.tickets.apiparser.model;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.enums.CabinClass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {
    private String country;
    private String currency;
    private String locale;
    private String originPlace;
    private String destinationPlace;
    private String outboundDate;
    private int adults;

    private CabinClass cabinType;
    private String children;
    private String infants;
}

