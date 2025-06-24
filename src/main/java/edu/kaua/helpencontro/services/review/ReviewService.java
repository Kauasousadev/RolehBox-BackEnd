package edu.kaua.helpencontro.services.review;

import edu.kaua.helpencontro.dto.request.review.ReviewRequestDTO;
import edu.kaua.helpencontro.dto.response.review.ReviewResponseDTO;
import edu.kaua.helpencontro.models.review.Review;
import edu.kaua.helpencontro.repositories.review.ReviewRepository;
import edu.kaua.helpencontro.services.mappers.review.ReviewRequestToEntity;
import edu.kaua.helpencontro.services.mappers.review.ReviewToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewRequestToEntity reviewRequestToEntity;
    @Autowired
    private ReviewToResponse reviewToResponse;

    public ResponseEntity<ReviewResponseDTO> addReview(ReviewRequestDTO review) {
        Review savedReview = reviewRepository.save(reviewRequestToEntity.apply(review));
        return ResponseEntity.ok(reviewToResponse.apply(savedReview));
    }

    //OTIMIZAR DEPOIS!
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviewsByRoleh(Long id) {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewResponseDTO> responseDTOList = new ArrayList<ReviewResponseDTO>();
        if (reviews != null) {
            for (Review review : reviews) {
                responseDTOList.add(reviewToResponse.apply(review));
            }
            return ResponseEntity.ok(responseDTOList);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<String> deleteReviewById(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return ResponseEntity.ok("Avaliação deletada com sucesso!");
        }else{
            return ResponseEntity.badRequest().body("Avaliação com id "+ id + " não existe.");
        }
    }
}
