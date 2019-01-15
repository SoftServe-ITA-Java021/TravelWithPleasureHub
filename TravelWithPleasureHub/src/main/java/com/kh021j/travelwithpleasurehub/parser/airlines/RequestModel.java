package com.kh021j.travelwithpleasurehub.parser.airlines;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class RequestModel {

    private String country;
    private String currency;
    private String locale;
    private String originPlace;
    private String destinationPlace;
    private String outboundDate;
    private String inboundDate;
    private int adults;
    private String cabinClass;
    private int children;
    private int infants;
}