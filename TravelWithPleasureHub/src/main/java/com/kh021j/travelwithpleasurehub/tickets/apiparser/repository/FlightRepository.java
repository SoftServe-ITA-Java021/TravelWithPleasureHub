package com.kh021j.travelwithpleasurehub.tickets.apiparser.repository;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
