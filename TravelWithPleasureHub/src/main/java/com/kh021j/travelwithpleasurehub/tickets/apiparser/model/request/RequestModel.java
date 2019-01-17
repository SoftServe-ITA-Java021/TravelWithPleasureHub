
package com.kh021j.travelwithpleasurehub.tickets.apiparser.model;

import lombok.*;

@Getter
@Setter
@ToString
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
    private String cabinType;
    private int children;
    private int infants;
}

