package edu.kaua.helpencontro.dto.request.auth;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignupRequest {
        @NotBlank @Size(min = 4, max = 20)
        private String username;
        @NotBlank @Size(max = 50)
        @Email
        private String email;
        @NotBlank @Size(min = 6, max = 40)
        private String password;
        private String role;
}