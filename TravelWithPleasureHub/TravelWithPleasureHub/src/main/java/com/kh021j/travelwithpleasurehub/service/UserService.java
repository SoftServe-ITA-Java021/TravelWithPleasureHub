package com.kh021j.travelwithpleasurehub.service;

import com.kh021j.travelwithpleasurehub.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    List<User> findUserByName(String username);
    User findByEmail(String email);
    User create (User user);
    Optional<User> getById(Integer id);
    User getUser(int id);
    User getUser(String email);
    User updateUser(User user);
    List<User> getUsers();
    void blockUser(int id);
}
