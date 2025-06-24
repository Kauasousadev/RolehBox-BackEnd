package edu.kaua.helpencontro.repositories.review;

import edu.kaua.helpencontro.models.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
