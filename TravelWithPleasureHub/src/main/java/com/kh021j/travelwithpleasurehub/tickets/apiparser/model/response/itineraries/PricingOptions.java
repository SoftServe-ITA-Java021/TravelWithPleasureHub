package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.itineraries;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingOptions {
    private String deeplinkUrl;
    private double price;
    private int quoteAgeInMinutes;
}
