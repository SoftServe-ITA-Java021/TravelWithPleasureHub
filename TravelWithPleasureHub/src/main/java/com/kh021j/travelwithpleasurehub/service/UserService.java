package com.kh021j.travelwithpleasurehub.service;

import com.kh021j.travelwithpleasurehub.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findUserByName(String username);
    void create (User user);
}
