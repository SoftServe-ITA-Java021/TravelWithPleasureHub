package com.kh021j.travelwithpleasurehub.propertyrent.repository;

import com.kh021j.travelwithpleasurehub.propertyrent.model.PropertyAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyAvailabilityRepository extends JpaRepository<PropertyAvailability, Integer> {

    @Query(value = "select * from property_availability where property_id = ?1", nativeQuery = true)
    Optional<List<PropertyAvailability>> findByPropertyId(Integer propertyId);

}
