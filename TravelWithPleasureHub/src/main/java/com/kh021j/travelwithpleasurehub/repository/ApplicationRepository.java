package com.kh021j.travelwithpleasurehub.repository;

import com.kh021j.travelwithpleasurehub.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
