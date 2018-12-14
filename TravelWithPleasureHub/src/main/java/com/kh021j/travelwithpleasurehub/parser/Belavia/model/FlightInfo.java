package com.kh021j.travelwithpleasurehub.parser.Belavia.model;

import com.kh021j.travelwithpleasurehub.parser.Belavia.model.enums.Currency;
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

}
