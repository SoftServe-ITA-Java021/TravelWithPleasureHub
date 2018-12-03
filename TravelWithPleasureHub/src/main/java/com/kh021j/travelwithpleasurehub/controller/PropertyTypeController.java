package com.kh021j.travelwithpleasurehub.controller;


import com.kh021j.travelwithpleasurehub.model.PropertyType;
import com.kh021j.travelwithpleasurehub.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/propertyType")
public class PropertyTypeController {

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @GetMapping
    public @ResponseBody Iterable<PropertyType> getAllPropertyTypes(){
        return propertyTypeRepository.findAll();
    }

    @PostMapping
    public @ResponseBody PropertyType addPropertyType(@RequestBody PropertyType propertyType) {
        return propertyTypeRepository.save(propertyType);
    }

    @PutMapping
    public @ResponseBody PropertyType updatePropertyType(@RequestBody PropertyType propertyType) {
        return propertyTypeRepository.save(propertyType);
    }

    @DeleteMapping
    public @ResponseBody void deletePropertyType(@RequestBody PropertyType propertyType) {
        propertyTypeRepository.delete(propertyType);
    }

    @GetMapping("/{id}")
    public @ResponseBody PropertyType getPropertyTypeById(@PathVariable Integer id) {
        return propertyTypeRepository.findById(id).orElse(null);
    }

}
