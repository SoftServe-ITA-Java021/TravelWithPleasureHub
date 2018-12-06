package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.Property;
import com.kh021j.travelwithpleasurehub.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
        return propertyRepository.findByPriceLessThanEqual(price).orElse(null);
    }

    @GetMapping(params = "sortByPrice")
    public @ResponseBody Iterable<Property> getPropertiesByPriceSortedBy(@RequestParam String sortBy) {
        if(sortBy.equals("asc")) return propertyRepository.findAllByOrderOrderByPriceAsc().orElse(null);
        else if(sortBy.equals("desc")) return propertyRepository.findAllByOrderOrderByPriceDesc().orElse(null);
        else return propertyRepository.findAll();
    }

    @GetMapping(params = "locality")
    public @ResponseBody Iterable<Property> getPropertiesByLocality(@RequestParam String locality) {
        return propertyRepository.findByLocality(locality).orElse(null);
    }

    @GetMapping(params = "address")
    public @ResponseBody Iterable<Property> getPropertiesByAddress(@RequestParam String address) {
        return propertyRepository.findByAddress(address).orElse(null);
    }

    @GetMapping(params = {"since", "until"})
    public @ResponseBody Iterable<Property> getPropertiesByDate(@RequestParam String since, @RequestParam String until) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);
        return propertyRepository.
                findByAvailabilityInPeriod(sinceDate, untilDate)
                    .orElse(null);
    }

    @GetMapping(params = {"since", "until", "sortByPrice"})
    public @ResponseBody Iterable<Property> getPropertiesByDateAndSortByPrice(@RequestParam String since,
                                                                              @RequestParam String until,
                                                                              @RequestParam String sortBy ) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);
        if (sortBy.equals("asc")) return propertyRepository.findByAvailabilityInPeriodAndSort(sinceDate, untilDate,
                new Sort(Sort.Direction.ASC, "price")).orElse(null);
        else if (sortBy.equals("desc")) return propertyRepository.findByAvailabilityInPeriodAndSort(sinceDate, untilDate,
                new Sort(Sort.Direction.DESC, "price")).orElse(null);
        else return propertyRepository.
                findByAvailabilityInPeriod(sinceDate, untilDate)
                .orElse(null);
    }

}
