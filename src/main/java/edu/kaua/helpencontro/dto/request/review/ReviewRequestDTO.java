package edu.kaua.helpencontro.dto.request.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReviewRequestDTO {
    private Long userId;
    private Long rolehId;
    private String reviewText;
    @Min(0)@Max(5)
    private Double reviewScore;
}
