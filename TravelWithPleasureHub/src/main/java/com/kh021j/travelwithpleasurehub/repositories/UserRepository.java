package com.kh021j.travelwithpleasurehub.repositories;

import com.kh021j.travelwithpleasurehub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
