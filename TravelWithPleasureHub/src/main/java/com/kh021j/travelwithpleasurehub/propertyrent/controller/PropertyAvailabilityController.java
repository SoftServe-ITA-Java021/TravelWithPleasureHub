package com.kh021j.travelwithpleasurehub.propertyrent.controller;


import com.kh021j.travelwithpleasurehub.propertyrent.model.PropertyAvailability;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyAvailabilityRepository;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyRepository;
import com.kh021j.travelwithpleasurehub.propertyrent.service.PropertyAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("api/property-availability")
@CrossOrigin
public class PropertyAvailabilityController {

    @Autowired
    private PropertyAvailabilityService propertyAvailabilityService;


    @GetMapping
    public @ResponseBody Iterable<PropertyAvailability> getAllPropertyAvailabilities(){
        return propertyAvailabilityService.findAll();
    }

    @PostMapping
    public @ResponseBody PropertyAvailability addPropertyAvailability(@RequestParam String checkIn,
                                                                      @RequestParam String checkOut,
                                                                      @RequestParam Integer propertyId
    ) {
        return propertyAvailabilityService.save(checkIn, checkOut, propertyId);
    }

    @PutMapping
    public @ResponseBody PropertyAvailability updatePropertyAvailability(
            @RequestBody PropertyAvailability propertyAvailability) {
        return propertyAvailabilityService.update(propertyAvailability);
    }

    @DeleteMapping
    public @ResponseBody void deletePropertyAvailability(@RequestBody PropertyAvailability propertyAvailability) {
        propertyAvailabilityService.delete(propertyAvailability);
    }

    @GetMapping("/{id}")
    public @ResponseBody Iterable<PropertyAvailability> getPropertyAvailabilityById(@PathVariable Integer id){
        return propertyAvailabilityService.findByPropertyId(id);
    }

}
