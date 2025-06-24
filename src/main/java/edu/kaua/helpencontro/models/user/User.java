package edu.kaua.helpencontro.models.user;

import edu.kaua.helpencontro.models.review.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Entity
@Table(name = "users")
@Data
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(unique = true, nullable = false, length = 20)
    private String email;

    @NotBlank
    @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String password;

    @OneToMany
    private Set<Review> reviews;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}