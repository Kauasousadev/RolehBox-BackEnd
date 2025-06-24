package edu.kaua.helpencontro.dto.response.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReviewResponseDTO {
    private String userName;
    private String RolehName;
    private String reviewText;
    @Min(0)@Max(5)
    private Double reviewScore;
    private LocalDateTime reviewDate;
}
