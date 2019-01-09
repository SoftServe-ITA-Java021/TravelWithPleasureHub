
package com.kh021j.travelwithpleasurehub.tickets.parser.Belavia.model;

import com.kh021j.travelwithpleasurehub.tickets.parser.Belavia.model.enums.Currency;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightInfo {

    private String price;
    private Currency currency;
    private String departureDateTime;
    private String arrivalDateTime;
    private String duration;
    private String origin;
    private String destination;

}
