package edu.kaua.helpencontro.services.users;

import edu.kaua.helpencontro.dto.request.auth.LoginRequest;
import edu.kaua.helpencontro.dto.request.auth.SignupRequest;
import edu.kaua.helpencontro.dto.response.JwtResponse;
import edu.kaua.helpencontro.dto.response.MessageResponse;
import edu.kaua.helpencontro.models.user.User;
import edu.kaua.helpencontro.models.user.UserRole;
import edu.kaua.helpencontro.repositories.user.UserRepository;
import edu.kaua.helpencontro.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtUtils jwtUtils;

    public AuthService(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken((User) authentication.getPrincipal());

        return new JwtResponse(
                jwt,
                loginRequest.username());
    }

    public MessageResponse registerUser(SignupRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new MessageResponse("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new MessageResponse("Error: Email is already in use!");
        }

        String encriptedPassword = new BCryptPasswordEncoder().encode(signUpRequest.getPassword());

        // Create new user's account
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encriptedPassword,
                UserRole.valueOf(signUpRequest.getRole().toUpperCase())
        );

        userRepository.save(user);

        return new MessageResponse("User registered successfully!");
    }
}