package com.kh021j.travelwithpleasurehub.repositories;

import com.kh021j.travelwithpleasurehub.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    Optional<Iterable<Property>> findByPriceLessThan(Integer price);

    Optional<Iterable<Property>> findByLocality(String locality);

    Optional<Iterable<Property>> findByAddress(String address);

}