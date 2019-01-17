package com.kh021j.travelwithpleasurehub.tickets.apiparser.repository;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDataRepository extends JpaRepository<FlightData, Integer> {
}
