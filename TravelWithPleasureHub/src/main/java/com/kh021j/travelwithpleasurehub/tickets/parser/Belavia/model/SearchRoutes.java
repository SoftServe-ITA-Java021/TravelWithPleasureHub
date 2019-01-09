
package com.kh021j.travelwithpleasurehub.tickets.parser.Belavia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRoutes {

    @JsonProperty
    private String origin;
    @JsonProperty
    private String destination;
    @JsonProperty
    private String departing;
    @JsonProperty
    private int direction;

}
