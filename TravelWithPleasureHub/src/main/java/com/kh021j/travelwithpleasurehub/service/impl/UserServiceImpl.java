package com.kh021j.travelwithpleasurehub.service.impl;

import com.kh021j.travelwithpleasurehub.userrelated.model.User;
import com.kh021j.travelwithpleasurehub.userrelated.repository.UserRepository;
import com.kh021j.travelwithpleasurehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findUsersByUsername(name);
    }

    @Transactional
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public Optional<User> getById(Integer id) {
        if (userRepository.existsById(id)){
            return Optional.of(userRepository.getOne(id));
        }
        return Optional.empty();
    }

}
