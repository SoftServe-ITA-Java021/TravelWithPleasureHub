package com.kh021j.travelwithpleasurehub.service;

import com.kh021j.travelwithpleasurehub.userrelated.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    List<User> findUserByName(String username);
    User create (User user);
    Optional<User> getById(Integer id);
}
