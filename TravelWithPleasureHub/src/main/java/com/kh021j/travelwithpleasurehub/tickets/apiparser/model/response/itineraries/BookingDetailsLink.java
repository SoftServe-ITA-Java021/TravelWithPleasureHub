package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.itineraries;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailsLink {
    private String method;
    private String uri;
    private String body;
}
