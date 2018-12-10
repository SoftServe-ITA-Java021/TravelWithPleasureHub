package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")

public class UserControllerRegistration {


    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @PostMapping (path = "")
    public void createUser (@RequestBody User user ){
        userService.create(user);
    }

}