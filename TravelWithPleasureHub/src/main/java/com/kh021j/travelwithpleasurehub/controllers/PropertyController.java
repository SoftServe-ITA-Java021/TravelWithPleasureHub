package com.kh021j.travelwithpleasurehub.controllers;

import com.kh021j.travelwithpleasurehub.models.Property;
import com.kh021j.travelwithpleasurehub.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/property")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping
    public @ResponseBody Iterable<Property> getAllProperties(){
        return propertyRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Property addProperty(@RequestBody Property property){
        return propertyRepository.save(property);
    }

    @PutMapping
    public @ResponseBody Property updateProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    @DeleteMapping
    public @ResponseBody void deleteProperty(@RequestBody Property property) {
        propertyRepository.delete(property);
    }

    @GetMapping("/{id}")
    public @ResponseBody Property getPropertyById(@PathVariable Integer id) {
        return propertyRepository.findById(id).orElse(null);
    }

    @GetMapping(params = "price")
    public @ResponseBody Iterable<Property> getPropertiesByPriceLessThan(@RequestParam Integer price) {
        return propertyRepository.findByPriceLessThan(price).orElse(null);
    }

    @GetMapping(params = "locality")
    public @ResponseBody Iterable<Property> getPropertiesByLocality(@RequestParam String locality) {
        return propertyRepository.findByLocality(locality).orElse(null);
    }

    @GetMapping(params = "address")
    public @ResponseBody Iterable<Property> getPropertiesByAddress(@RequestParam String address) {
        return propertyRepository.findByAddress(address).orElse(null);
    }

    //TODO: filter by rent period

}
