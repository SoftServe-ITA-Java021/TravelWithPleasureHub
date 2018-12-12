//package com.kh021j.travelwithpleasurehub.service.impl;
//
//import com.kh021j.travelwithpleasurehub.model.User;
//import com.kh021j.travelwithpleasurehub.repository.UserRepository;
//import com.kh021j.travelwithpleasurehub.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Transactional
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Transactional
//    @Override
//    public List<User> findUserByName(String name) {
//        return userRepository.findUsersByUsername(name);
//    }
//
//    @Override
//    public void create(User user) {
//        userRepository.save(user);
//    }
//
//}
