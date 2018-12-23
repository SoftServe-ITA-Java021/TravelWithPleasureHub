package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.controller.enumeration.SortType;
import com.kh021j.travelwithpleasurehub.model.UserReview;
import com.kh021j.travelwithpleasurehub.repository.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user-reviews")
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
    public @ResponseBody Iterable<UserReview> getUserReviewsByUserId(@RequestParam Integer userId) {
        return userReviewRepository.findByUserId(userId).orElse(null);
    }

    @GetMapping(params = "sortByDateRated")
    public @ResponseBody Iterable<UserReview> getUserReviewsSortedByDateRated(@RequestParam String sortByDateRated) {
        switch (SortType.valueOf(sortByDateRated.toUpperCase())) {
            case ASC:
                return userReviewRepository.findAllByOrderByDateRatedAsc().orElse(null);
            case DESC:
                return userReviewRepository.findAllByOrderByDateRatedDesc().orElse(null);
            default:
                return userReviewRepository.findAll();
        }
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
