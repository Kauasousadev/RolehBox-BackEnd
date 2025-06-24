package edu.kaua.helpencontro.services.mappers.review;

import edu.kaua.helpencontro.dto.response.review.ReviewResponseDTO;
import edu.kaua.helpencontro.models.review.Review;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ReviewToResponse implements Function<Review, ReviewResponseDTO> {
    @Override
    public ReviewResponseDTO apply(Review review) {
        return new ReviewResponseDTO(
                review.getUser().getUsername(),
                review.getRoleh().getName(),
                review.getReviewText(),
                review.getReviewScore(),
                review.getReviewDate()
        );
    }
}
