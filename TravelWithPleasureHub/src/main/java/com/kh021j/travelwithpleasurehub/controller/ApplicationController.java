package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.Application;
import com.kh021j.travelwithpleasurehub.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    public @ResponseBody Iterable<Application> getAllApplications(){
        return applicationRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Application getApplicationById(@PathVariable Integer id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @PostMapping
    public @ResponseBody Application addApplication(@RequestBody Application application){
        return applicationRepository.save(application);
    }

    @PutMapping
    public @ResponseBody Application updateApplication(@RequestBody Application application) {
        return applicationRepository.save(application);
    }

    @DeleteMapping
    public @ResponseBody void deleteApplication(@RequestBody Application application) {
        applicationRepository.delete(application);
    }

}
