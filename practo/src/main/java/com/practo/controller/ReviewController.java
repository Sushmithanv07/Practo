package com.practo.controller;

import com.practo.entity.Review;
import com.practo.payload.DoctorDto;
import com.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
      return new ResponseEntity<>( reviewService.createReview(review), HttpStatus.CREATED);
    }
    public ResponseEntity<DoctorDto> getReviewsByDoctorId(long doctorId){
        return null;
    }

}
