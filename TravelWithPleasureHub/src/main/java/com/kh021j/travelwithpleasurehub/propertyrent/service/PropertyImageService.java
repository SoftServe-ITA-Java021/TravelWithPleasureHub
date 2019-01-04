package com.kh021j.travelwithpleasurehub.propertyrent.service;


import com.kh021j.travelwithpleasurehub.propertyrent.model.PropertyImage;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyImageRepository;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyImageService {

    @Autowired
    private PropertyImageRepository propertyImageRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public Iterable<PropertyImage> findAll(){
        return propertyImageRepository.findAll();
    }

    public PropertyImage findById(Integer id) {
        return propertyImageRepository.findById(id).orElse(null);
    }

    public Iterable<PropertyImage> findByPropertyId(Integer propertyId) {
        return propertyImageRepository.findByPropertyId(propertyId).orElse(null);
    }

    public PropertyImage findFirstByPropertyId(Integer propertyId) {
        return propertyImageRepository.findFirstByPropertyId(propertyId);
    }

    public PropertyImage add(PropertyImage propertyImage){
        return propertyImageRepository.save(propertyImage);
    }

    public PropertyImage update(PropertyImage propertyImage) {
        if(propertyImageRepository.findById(propertyImage.getId()).isPresent())
            return propertyImageRepository.save(propertyImage);
        else return null;
    }

    public void delete(PropertyImage propertyImage) {
        propertyImageRepository.delete(propertyImage);
    }
}
