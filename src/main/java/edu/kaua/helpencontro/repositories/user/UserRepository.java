package edu.kaua.helpencontro.repositories.user;

import edu.kaua.helpencontro.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
    UserDetails existsByUsername(String username);
    Boolean existsByEmail(String email);
}
