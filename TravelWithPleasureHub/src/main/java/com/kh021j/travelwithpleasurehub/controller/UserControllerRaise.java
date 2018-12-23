package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.repository.UserRepository;
import com.kh021j.travelwithpleasurehub.service.UserService;
import com.kh021j.travelwithpleasurehub.service.dto.UserDTO;
import com.kh021j.travelwithpleasurehub.utils.FromDTO;
import com.kh021j.travelwithpleasurehub.utils.ToDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/user")
public class UserControllerRaise {


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