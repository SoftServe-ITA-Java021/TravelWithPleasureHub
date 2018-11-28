package com.kh021j.travelwithpleasurehub.repositories;

import com.kh021j.travelwithpleasurehub.models.PropertyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyReviewRepository extends JpaRepository<PropertyReview, Integer> {

}