package com.kh021j.travelwithpleasurehub.repositories;

import com.kh021j.travelwithpleasurehub.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
