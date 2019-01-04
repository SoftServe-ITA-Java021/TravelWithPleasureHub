package com.kh021j.travelwithpleasurehub.propertyrent.repository;

import com.kh021j.travelwithpleasurehub.propertyrent.model.PropertyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyReviewRepository extends JpaRepository<PropertyReview, Integer> {

    Optional<Iterable<PropertyReview>> findByPropertyId(Integer propertyId);

    Optional<Iterable<PropertyReview>> findAllByOrderByDateRatedAsc();

    Optional<Iterable<PropertyReview>> findAllByOrderByDateRatedDesc();

}