package com.kh021j.travelwithpleasurehub.propertyrent.service;

import com.kh021j.travelwithpleasurehub.controller.enumeration.SortType;
import com.kh021j.travelwithpleasurehub.propertyrent.model.Property;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public Iterable<Property> filterProperties(String locality, String address, String checkIn, String checkOut) {
        System.out.println(locality);
        System.out.println(address);
        System.out.println(checkIn);
        System.out.println(checkOut);
        if(!locality.equals("") && address.equals("") && checkIn.equals("") && checkOut.equals("")) {
            System.out.println("1");
            return propertyRepository.findByLocality(locality).orElse(new ArrayList<>());
        } else if(locality.equals("") && !address.equals("") && checkIn.equals("") && checkOut.equals("")) {
            System.out.println("2");
            return propertyRepository.findByAddress(address).orElse(new ArrayList<>());
        } else if(!locality.equals("") && !address.equals("") && checkIn.equals("") && checkOut.equals("")) {
            System.out.println("3");
            return propertyRepository.findByLocalityAndAddress(locality, address).orElse(new ArrayList<>());
        } else if(!locality.equals("") && address.equals("") && !checkIn.equals("") && !checkOut.equals("")) {
            System.out.println("4");
            LocalDate checkInDate = LocalDate.parse(checkIn);
            LocalDate checkOutDate = LocalDate.parse(checkOut);
            return propertyRepository.findByAvailabilityInPeriodAndLocality(checkInDate, checkOutDate, locality)
                    .orElse(new ArrayList<>());
        }
        return propertyRepository.findAll();
    }


    public Iterable<Property> findByAvailabilityInPeriod(String since, String until) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);
        return propertyRepository.
                findByAvailabilityInPeriod(sinceDate, untilDate).orElse(new ArrayList<>());
    }

    public Iterable<Property> findByAvailabilityInPeriodAndSort(String since, String until, String sortByPrice) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);
        switch (SortType.valueOf(sortByPrice.toUpperCase())) {
            case ASC:
                return propertyRepository.findByAvailabilityInPeriodAndSort(
                        sinceDate, untilDate, SortType.ASC.name()).orElse(new ArrayList<>());
            case DESC:
                return propertyRepository.findByAvailabilityInPeriodAndSort(
                        sinceDate, untilDate, SortType.DESC.name()).orElse(new ArrayList<>());
            default:
                return propertyRepository.
                        findByAvailabilityInPeriod(sinceDate, untilDate)
                        .orElse(new ArrayList<>());
        }
    }

}