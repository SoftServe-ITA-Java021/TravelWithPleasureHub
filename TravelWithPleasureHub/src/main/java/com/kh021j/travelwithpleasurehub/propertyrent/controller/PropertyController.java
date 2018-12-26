package com.kh021j.travelwithpleasurehub.propertyrent.controller;

import com.kh021j.travelwithpleasurehub.controller.enumeration.SortType;
import com.kh021j.travelwithpleasurehub.propertyrent.model.Property;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyRepository;
import com.kh021j.travelwithpleasurehub.propertyrent.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public @ResponseBody Iterable<Property> getAllProperties(){
        return propertyService.findAll();
    }

    @PostMapping
    public @ResponseBody Property addProperty(@RequestBody Property property){
        return propertyService.add(property);
    }

    @PutMapping
    public @ResponseBody Property updateProperty(@RequestBody Property property) {
        return propertyService.update(property);
    }

    @DeleteMapping
    public @ResponseBody void deleteProperty(@RequestBody Property property) {
        propertyService.delete(property);
    }

    @GetMapping("/{id}")
    public @ResponseBody Property getPropertyById(@PathVariable Integer id) {
        return propertyService.findById(id);
    }

    @GetMapping(params = "price")
    public @ResponseBody Iterable<Property> getPropertiesByPriceLessThan(@RequestParam Integer price) {
        return propertyService.findByPriceLessThanEqual(price);
    }

    @GetMapping(params = "sortByPrice")
    public @ResponseBody Iterable<Property> getPropertiesByPriceSortedBy(@RequestParam String sortByPrice) {
        return propertyService.findAllByOrderByPrice(sortByPrice);
    }

    @GetMapping(params = "locality")
    public @ResponseBody Iterable<Property> getPropertiesByLocality(@RequestParam String locality) {
        return propertyService.findByLocality(locality);
    }

    @GetMapping(params = "address")
    public @ResponseBody Iterable<Property> getPropertiesByAddress(@RequestParam String address) {
        return propertyService.findByAddress(address);
    }

    @GetMapping(params = {"since", "until"})
    public @ResponseBody Iterable<Property> getPropertiesByDate(@RequestParam String since, @RequestParam String until) {
        return propertyService.findByAvailabilityInPeriod(since, until);
    }

    @GetMapping(params = {"since", "until", "sortByPrice"})
    public @ResponseBody Iterable<Property> getPropertiesByDateAndSortByPrice(@RequestParam String since,
                                                                              @RequestParam String until,
                                                                              @RequestParam String sortByPrice
    ) {
        return propertyService.findByAvailabilityInPeriodAndSort(since, until, sortByPrice);
    }

}
