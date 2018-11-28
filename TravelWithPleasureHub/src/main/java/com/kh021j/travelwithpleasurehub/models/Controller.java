package com.kh021j.travelwithpleasurehub.models;

import com.kh021j.travelwithpleasurehub.repositories.PropertyAvailabilityRepository;
import com.kh021j.travelwithpleasurehub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class Controller {

    @Autowired
    private PropertyAvailabilityRepository propertyAvailabilityRepository;

    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<PropertyAvailability> getAllUsers() {
        return propertyAvailabilityRepository.findAll();
    }
}
