package com.kh021j.travelwithpleasurehub.service.impl;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.model.enumiration.UserRole;
import com.kh021j.travelwithpleasurehub.repository.UserRepository;
import com.kh021j.travelwithpleasurehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("userService")
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

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public User create(User user) {
        user.setRole(UserRole.ROLE_USER);
        user.setEnabled(true);

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

    @Override
    public User getUser(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
       return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void blockUser(int id) {
       User user = this.getUser(id);
       user.setEnabled(!user.isEnabled());
       this.updateUser(user);
    }

}
