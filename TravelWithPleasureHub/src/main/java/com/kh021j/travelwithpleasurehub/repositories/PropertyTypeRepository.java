package com.kh021j.travelwithpleasurehub.repositories;

import com.kh021j.travelwithpleasurehub.models.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {

}