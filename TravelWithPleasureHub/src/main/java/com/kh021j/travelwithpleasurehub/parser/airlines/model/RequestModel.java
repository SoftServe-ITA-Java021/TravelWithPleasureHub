package com.kh021j.travelwithpleasurehub.parser.airlines.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestModel {

    private String country;
    private String currency;
    private String locale;
    private String originPlace;
    private String destinationPlace;
    private String outboundDate;
    private int adults;
    private String cabinClass;
    private int children;
    private int infants;

}