package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@RestController
@Secured("ROLE_ADMIN")
@RequestMapping("/admin/clients")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/getUsers",method = RequestMethod.GET)
    public List<User> getUsers(){return userService.getUsers();}

    @RequestMapping(value = "/admin/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void blockUser(@PathVariable("id") int userID){
        userService.blockUser(userID);
    }
}
