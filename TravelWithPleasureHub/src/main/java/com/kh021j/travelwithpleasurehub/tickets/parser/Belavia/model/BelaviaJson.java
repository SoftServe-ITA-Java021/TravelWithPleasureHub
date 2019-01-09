
package com.kh021j.travelwithpleasurehub.tickets.parser.Belavia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kh021j.travelwithpleasurehub.tickets.parser.Belavia.model.enums.Currency;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BelaviaJson {

    @JsonProperty
    private Currency currency;
    @JsonProperty
    private List<SearchRoutes> searchRoutes;
    @JsonProperty
    private List<PassengerQuantities> passengerQuantities;

}
