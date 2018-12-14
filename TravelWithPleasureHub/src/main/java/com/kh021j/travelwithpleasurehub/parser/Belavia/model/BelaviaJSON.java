
package com.kh021j.travelwithpleasurehub.parser.Belavia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BelaviaJSON {

    @JsonProperty
    private String currency;
    @JsonProperty
    private List<SearchRoutes> searchRoutes;
    @JsonProperty
    private List<PassengerQuantities> passengerQuantities;

}
