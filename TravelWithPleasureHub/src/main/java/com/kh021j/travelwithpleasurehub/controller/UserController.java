package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public @ResponseBody User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping
    public @ResponseBody User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    public @ResponseBody void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }

    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

}