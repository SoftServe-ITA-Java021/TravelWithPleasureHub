package com.kh021j.travelwithpleasurehub.controllers;


import com.kh021j.travelwithpleasurehub.models.PropertyAvailability;
import com.kh021j.travelwithpleasurehub.repositories.PropertyAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/propertyAvailability")
public class PropertyAvailabilityController {

    @Autowired
    private PropertyAvailabilityRepository propertyAvailabilityRepository;

    @GetMapping
    public @ResponseBody
    Iterable<PropertyAvailability> getAllPropertyAvailabilities(){
        return propertyAvailabilityRepository.findAll();
    }

    @PostMapping
    public @ResponseBody PropertyAvailability addPropertyAvailability(
            @RequestBody PropertyAvailability propertyAvailability) {
        return propertyAvailabilityRepository.save(propertyAvailability);
    }

    @PutMapping
    public @ResponseBody PropertyAvailability updatePropertyAvailability(
            @RequestBody PropertyAvailability propertyAvailability) {
        return propertyAvailabilityRepository.save(propertyAvailability);
    }

    @DeleteMapping
    public @ResponseBody void deletePropertyAvailability(@RequestBody PropertyAvailability propertyAvailability) {
        propertyAvailabilityRepository.delete(propertyAvailability);
    }

    @GetMapping("/{id}")
    public @ResponseBody PropertyAvailability getPropertyAvailabilityById(@PathVariable Integer id){
        return propertyAvailabilityRepository.findById(id).orElse(null);
    }

}
