package edu.kaua.helpencontro.services.mappers.review;

import edu.kaua.helpencontro.dto.request.review.ReviewRequestDTO;
import edu.kaua.helpencontro.exceptions.ResourceNotFoundException;
import edu.kaua.helpencontro.models.review.Review;
import edu.kaua.helpencontro.models.roleh.Roleh;
import edu.kaua.helpencontro.models.user.User;
import edu.kaua.helpencontro.repositories.roleh.RolehRepository;
import edu.kaua.helpencontro.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class ReviewRequestToEntity implements Function<ReviewRequestDTO, Review> {

    @Autowired
    RolehRepository rolehRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Review apply(ReviewRequestDTO reviewRequestDTO) {
        return new Review(
                verifyUser(reviewRequestDTO.getUserId()),
                verifyRoleh(reviewRequestDTO.getRolehId()),
                reviewRequestDTO.getReviewText(),
                reviewRequestDTO.getReviewScore(),
                LocalDateTime.now()
        );
    }

    public Roleh verifyRoleh(Long id){
        if (rolehRepository.existsById(id)) {
            return rolehRepository.findById(id).get();
        }else throw new ResourceNotFoundException("Roleh não encontrado pelo id!");
    }

    public User verifyUser(Long id){
        if (userRepository.existsById(id)) {
            return userRepository.findById(id).get();
        }else throw new ResourceNotFoundException("Usuário não encontrado pelo id!");
    }
}
