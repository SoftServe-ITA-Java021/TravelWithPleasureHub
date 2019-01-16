
package com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model.enums.Currency;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BelaviaJson {

    @JsonProperty
    private Currency currency;
    @JsonProperty
    private List<SearchRoutes> searchRoutes;
    @JsonProperty
    private List<PassengerQuantities> passengerQuantities;

}
