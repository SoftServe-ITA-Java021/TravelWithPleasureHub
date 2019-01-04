package com.kh021j.travelwithpleasurehub.propertyrent.service;

import com.kh021j.travelwithpleasurehub.controller.enumeration.SortType;
import com.kh021j.travelwithpleasurehub.propertyrent.model.Property;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;


    public Iterable<Property> findAll(){
        return propertyRepository.findAll();
    }

    public Property add(Property property){
        return propertyRepository.save(property);
    }

    public Property update(Property property) {
        if(propertyRepository.findById(property.getId()).isPresent())
            return propertyRepository.save(property);
        else return null;
    }

    public void delete(Property property) {
        propertyRepository.delete(property);
    }

    public Property findById(Integer id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public Iterable<Property> findByPriceLessThanEqual(Integer price) {
        return propertyRepository.findByPriceLessThanEqual(price).orElse(null);
    }

    public Iterable<Property> findAllByOrderByPrice(String sortByPrice) {
        switch (SortType.valueOf(sortByPrice.toUpperCase())) {
            case ASC:
                return propertyRepository.findAllByOrderByPriceAsc().orElse(null);
            case DESC:
                return propertyRepository.findAllByOrderByPriceDesc().orElse(null);
            default:
                return propertyRepository.findAll();
        }
    }

    public Iterable<Property> findByLocality(String locality) {
        return propertyRepository.findByLocality(locality).orElse(null);
    }

    public Iterable<Property> findByAddress(String address) {
        return propertyRepository.findByAddress(address).orElse(null);
    }

    public Iterable<Property> findByAvailabilityInPeriod(String since, String until) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);
        return propertyRepository.
                findByAvailabilityInPeriod(sinceDate, untilDate).orElse(null);
    }

    public Iterable<Property> findByAvailabilityInPeriodAndSort(String since, String until, String sortByPrice) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);
        switch (SortType.valueOf(sortByPrice.toUpperCase())) {
            case ASC:
                return propertyRepository.findByAvailabilityInPeriodAndSort(
                        sinceDate, untilDate, SortType.ASC.name()).orElse(null);
            case DESC:
                return propertyRepository.findByAvailabilityInPeriodAndSort(
                        sinceDate, untilDate, SortType.DESC.name()).orElse(null);
            default:
                return propertyRepository.
                        findByAvailabilityInPeriod(sinceDate, untilDate)
                        .orElse(null);
        }
    }

}
