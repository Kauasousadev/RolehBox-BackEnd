package edu.kaua.helpencontro.models.review;

import edu.kaua.helpencontro.models.roleh.Roleh;
import edu.kaua.helpencontro.models.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Roleh roleh;

    private String reviewText;

    @Min(0)@Max(5)
    private Double reviewScore;

    private LocalDateTime reviewDate;

    public Review() {}

    public Review(User user, Roleh roleh, String reviewText, Double reviewScore, LocalDateTime reviewDate) {
        this.user = user;
        this.roleh = roleh;
        this.reviewText = reviewText;
        this.reviewScore = reviewScore;
        this.reviewDate = reviewDate;
    }
}
