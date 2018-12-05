package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.UserReview;
import com.kh021j.travelwithpleasurehub.repository.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/propertyReview")
public class UserReviewController {

    @Autowired
    private UserReviewRepository userReviewRepository;

    @GetMapping
    public @ResponseBody Iterable<UserReview> getAllUserReviews(){
        return userReviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody UserReview getUserReviewById(@PathVariable Integer id) {
        return userReviewRepository.findById(id).orElse(null);
    }

    @GetMapping(params = "userId")
    public @ResponseBody Iterable<UserReview> getUserReviewsByPropertyId(@RequestParam Integer userId) {
        return userReviewRepository.findByUserId(userId).orElse(null);
    }

    @GetMapping(params = "sortByDateRated")
    public @ResponseBody Iterable<UserReview> getUserReviewsSortedByDateRated(@RequestParam String sortBy) {
        if(sortBy.equals("asc")) return userReviewRepository.findAllByOrderOrderByDateRatedAsc().orElse(null);
        else if(sortBy.equals("desc")) return userReviewRepository.findAllByOrderOrderByDateRatedDesc().orElse(null);
        else return userReviewRepository.findAll();
    }

    @PostMapping
    public @ResponseBody UserReview addUserReview(@RequestBody UserReview userReview){
        return userReviewRepository.save(userReview);
    }

    @PutMapping
    public @ResponseBody UserReview updateUserReview(@RequestBody UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    @DeleteMapping
    public @ResponseBody void deleteUserReview(@RequestBody UserReview userReview) {
        userReviewRepository.delete(userReview);
    }

}
