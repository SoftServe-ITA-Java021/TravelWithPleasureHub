package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@RestController
@Secured("ROLE_USER")
@RequestMapping("/user/profiles")
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUser(authentication.getName());
    }

    @RequestMapping(value = "/user/change", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public User changeUser(@Valid @RequestBody User userDto){
        return userService.updateUser(userDto);
    }
}
