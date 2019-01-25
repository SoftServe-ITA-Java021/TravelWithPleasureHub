package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response;

import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDataResponse {

    private String departureAirport;

    private String arrivalAirport;

    private LocalDate queryDate;

    private String cabinType;

    private String company;

    private String imageCompany;

    private Currency currency;

    private Integer adults;

    private Integer children;

    private Integer infants;

    private String duration;

    private ZonedDateTime departureTime;

    private ZonedDateTime arrivalTime;

    private String linkForBuying;

    private Double price;

}
