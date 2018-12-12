package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.repository.PropertyRepository;
import com.kh021j.travelwithpleasurehub.service.PropertyPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/propertyphoto")
public class PropertyPhotoController {

    @Autowired
    private PropertyPhotoService propertyPhotoService;

    @Autowired
    private PropertyRepository propertyRepository;

    @PostMapping
    public @ResponseBody String uploadPhoto(
            @RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
        return propertyPhotoService.save(file, id);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<byte[]> getPropertyPhoto(@RequestParam("id") Integer id) {
        return propertyPhotoService.getPropertyPhoto(id);
    }

}
