//package com.kh021j.travelwithpleasurehub.controller;
//
//import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyRepository;
//import com.kh021j.travelwithpleasurehub.propertyrent.service.PropertyPhotoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping(path = "/api/property-photos")
//public class PropertyPhotoController {
//
//    @Autowired
//    private PropertyPhotoService propertyPhotoService;
//
//    @PostMapping
//    public @ResponseBody String uploadPhoto(
//            @RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
//        return propertyPhotoService.save(file, id);
//    }
//
//    @PostMapping
//    public @ResponseBody String uploadPhotos(
//            @RequestParam("files") MultipartFile[] files, @RequestParam("ids") Integer[] ids) {
//        return propertyPhotoService.savePhotos(files, ids);
//    }
//
//    @GetMapping
//    public @ResponseBody ResponseEntity<byte[]> getPropertyPhoto(@RequestParam("id") Integer id) {
//        return propertyPhotoService.getPropertyPhoto(id);
//    }
//
//    @GetMapping
//    public @ResponseBody ResponseEntity<byte[][]> getPropertyPhotos(@RequestParam("ids") Integer[] ids) {
//        return propertyPhotoService.getPropertyPhotos(ids);
//    }
//
//}
