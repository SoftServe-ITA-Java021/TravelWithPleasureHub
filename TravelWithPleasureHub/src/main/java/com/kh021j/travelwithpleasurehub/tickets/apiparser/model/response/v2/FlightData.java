package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2;

import com.kh021j.travelwithpleasurehub.tickets.parser.belavia.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flight_data")
public class FlightData {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "query_date")
    private LocalDate queryDate;

    @Column(name = "cabin_type")
    private String cabinType;

    @Column(name = "company")
    private String company;

    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "image_company")
    private String imageCompany;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL)
    List<Flight> flights;
}
