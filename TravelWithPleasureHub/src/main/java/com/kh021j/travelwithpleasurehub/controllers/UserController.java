package com.kh021j.travelwithpleasurehub.controllers;

import com.kh021j.travelwithpleasurehub.models.User;
import com.kh021j.travelwithpleasurehub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<User> getAllAuthors(){
        return userRepository.findAll();
    }

    @PostMapping(path = "/addUser")
    public @ResponseBody void addAuthor(@RequestBody User user){
        userRepository.save(user);
    }
}