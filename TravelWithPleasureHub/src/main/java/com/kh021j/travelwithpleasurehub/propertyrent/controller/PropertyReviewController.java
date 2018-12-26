package com.kh021j.travelwithpleasurehub.propertyrent.controller;

import com.kh021j.travelwithpleasurehub.controller.enumeration.SortType;
import com.kh021j.travelwithpleasurehub.propertyrent.model.PropertyReview;
import com.kh021j.travelwithpleasurehub.propertyrent.repository.PropertyReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/property-reviews")
public class PropertyReviewController {

    @Autowired
    private PropertyReviewRepository propertyReviewRepository;

    @GetMapping
    public @ResponseBody Iterable<PropertyReview> getAllPropertyReviews(){
        return propertyReviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody PropertyReview getPropertyReviewById(@PathVariable Integer id) {
        return propertyReviewRepository.findById(id).orElse(null);
    }

    @GetMapping(params = "propertyId")
    public @ResponseBody Iterable<PropertyReview> getPropertyReviewsByPropertyId(@RequestParam Integer propertyId) {
        return propertyReviewRepository.findByPropertyId(propertyId).orElse(null);
    }

    @GetMapping(params = "sortByDateRated")
    public @ResponseBody Iterable<PropertyReview> getPropertyReviewsSortedByDateRated(@RequestParam String sortByDateRated) {
        switch (SortType.valueOf(sortByDateRated.toUpperCase())) {
            case ASC:
                return propertyReviewRepository.findAllByOrderByDateRatedAsc().orElse(null);
            case DESC:
                return propertyReviewRepository.findAllByOrderByDateRatedDesc().orElse(null);
            default:
                return propertyReviewRepository.findAll();
        }
    }

    @PostMapping
    public @ResponseBody PropertyReview addPropertyReview(@RequestBody PropertyReview propertyReview){
        return propertyReviewRepository.save(propertyReview);
    }

    @PutMapping
    public @ResponseBody PropertyReview updatePropertyReview(@RequestBody PropertyReview propertyReview) {
        return propertyReviewRepository.save(propertyReview);
    }

    @DeleteMapping
    public @ResponseBody void deletePropertyReview(@RequestBody PropertyReview propertyReview) {
        propertyReviewRepository.delete(propertyReview);
    }

}
