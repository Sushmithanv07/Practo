package com.practo.service.serviceimpl;

import com.practo.entity.Doctor;
import com.practo.entity.Patient;
import com.practo.entity.Review;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import com.practo.repository.ReviewRepository;
import com.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ReviewRepository ReviewRepo;

    @Override
    public Review createReview(Review review) {
        Doctor doctor = doctorRepo.findById(review.getDoctorId()).get();
        Patient patient = patientRepo.findById(review.getPatientId()).get();
        Review savedReview = null;

        if (doctor != null || patient != null) {
            savedReview = ReviewRepo.save(review);
        }
        return savedReview;
    }
    public List<Review> getReviewByDoctorId(long doctorId){
        List<Review> reviews = reviewRepo.findByDoctorId(doctorId);
        return reviews;
    }
}
