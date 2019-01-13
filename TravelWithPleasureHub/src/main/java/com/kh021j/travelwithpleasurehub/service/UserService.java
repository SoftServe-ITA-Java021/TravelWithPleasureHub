package com.kh021j.travelwithpleasurehub.service;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findUserByName(String name) {
        return userRepository.findUsersByUsername(name);
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getById(Integer id) {
        if (userRepository.existsById(id)){
            return Optional.of(userRepository.getOne(id));
        }
        return Optional.empty();
    }

}
