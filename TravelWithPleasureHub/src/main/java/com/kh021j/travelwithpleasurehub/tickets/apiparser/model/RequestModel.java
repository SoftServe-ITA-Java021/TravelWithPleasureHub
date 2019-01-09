package com.kh021j.travelwithpleasurehub.tickets.api_parser.model;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.kh021j.travelwithpleasurehub.tickets.api_parser.enums.CabinClass;

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

//    private String inboundDate;
    private CabinClass cabinType;
    private String children;
    private String infants;
//    private String includeCarries;
//    private String excludeCarries;
//    private boolean groupPricing;
}

