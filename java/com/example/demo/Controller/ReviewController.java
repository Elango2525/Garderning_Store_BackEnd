package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Review;
import com.example.demo.Repository.ReviewRepository;

import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
    }

    @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable Long productId) {
        // Assuming you have a product ID associated with reviews
        // Retrieve and return reviews for the given productId
        return reviewRepository.findAllByProductId(productId);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        // Save the review in the database
        return reviewRepository.save(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        // Find the review by ID and update its details
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));

        review.setCustomerName(reviewDetails.getCustomerName());
        review.setRating(reviewDetails.getRating());
        review.setComment(reviewDetails.getComment());

        return reviewRepository.save(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        // Delete the review by ID
        reviewRepository.deleteById(id);
    }
}
