
package com.kh021j.travelwithpleasurehub.parser.belavia.model;

import com.kh021j.travelwithpleasurehub.parser.belavia.model.enums.Currency;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class FlightInfo {

    private String price;
    private Currency currency;
    private String departureDateTime;
    private String arrivalDateTime;
    private String duration;
    private String origin;
    private String destination;

}
