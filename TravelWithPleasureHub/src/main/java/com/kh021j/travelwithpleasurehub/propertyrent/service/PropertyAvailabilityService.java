package com.kh021j.travelwithpleasurehub.propertyrent.service;


import com.kh021j.travelwithpleasurehub.propertyrent.model.PropertyAvailability;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyAvailabilityRepository;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class PropertyAvailabilityService {

    @Autowired
    private PropertyAvailabilityRepository propertyAvailabilityRepository;

    @Autowired
    private PropertyRepository propertyRepository;


    public Iterable<PropertyAvailability> findAll(){
        return propertyAvailabilityRepository.findAll();
    }

    public PropertyAvailability save(String checkIn, String checkOut, Integer propertyId) {
        LocalDate checkInDate = LocalDate.parse(checkIn);
        LocalDate checkOutDate = LocalDate.parse(checkOut);
        PropertyAvailability propertyAvailability = new PropertyAvailability(
                checkInDate, checkOutDate, propertyRepository.findById(propertyId).orElse(null));
        return propertyAvailabilityRepository.save(propertyAvailability);
    }

    public PropertyAvailability update(PropertyAvailability propertyAvailability) {
        return propertyAvailabilityRepository.save(propertyAvailability);
    }

    public void delete(PropertyAvailability propertyAvailability) {
        propertyAvailabilityRepository.delete(propertyAvailability);
    }

    public Iterable<PropertyAvailability> findByPropertyId(Integer id){
        return propertyAvailabilityRepository.findByPropertyId(id).orElse(new ArrayList<>());
    }
}
