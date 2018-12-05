package com.kh021j.travelwithpleasurehub.repository;

import com.kh021j.travelwithpleasurehub.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Integer> {

    Optional<Iterable<UserReview>> findByUserId(Integer userId);

    Optional<Iterable<UserReview>> findAllByOrderOrderByDateRatedAsc();

    Optional<Iterable<UserReview>> findAllByOrderOrderByDateRatedDesc();

}
