package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ProfilesController {

    @Autowired
    private UserService userService;



    @GetMapping("/{id}")
    @CrossOrigin(origins="http://localhost:3000")
    public ResponseEntity<?> findUserById(@PathVariable Integer id) {
        Optional<User> user = Optional.ofNullable(userService.getUser(id));
        return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/change",method = RequestMethod.PUT)
    @CrossOrigin(origins="http://localhost:3000")
    @ResponseStatus(HttpStatus.OK)
    public User changeUser(@Valid @RequestBody User user){
        return userService.update(user);
    }
}
