package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.itineraries;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Itineraries {
    private BookingDetailsLink bookingDetailsLink;
    private String outboundLegId;
    private PricingOptions[] pricingOptions;
}
