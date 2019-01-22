package com.kh021j.travelwithpleasurehub.tickets.apiparser.repository;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDataRepository extends JpaRepository<FlightData, Integer> {

    List<FlightData> findAllByDepartureAirportAndArrivalAirportAndQueryDate
            (String departureAirport, String arrivalAirport, String localDate);
}
