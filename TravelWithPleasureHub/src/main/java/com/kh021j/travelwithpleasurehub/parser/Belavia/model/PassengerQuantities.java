
package com.kh021j.travelwithpleasurehub.parser.Belavia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerQuantities {

    @JsonProperty
    private String code;
    @JsonProperty
    private int quantity;

}
