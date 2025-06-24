package edu.kaua.helpencontro.controller.review;

import edu.kaua.helpencontro.dto.request.review.ReviewRequestDTO;
import edu.kaua.helpencontro.dto.response.review.ReviewResponseDTO;
import edu.kaua.helpencontro.services.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody ReviewRequestDTO reviewRequestDTO){
        return reviewService.addReview(reviewRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviewsByRoleh(@PathVariable Long id){
        return reviewService.getAllReviewsByRoleh(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id){
        return reviewService.deleteReviewById(id);
    }
}
