package edu.kaua.helpencontro.controller.auth;

import edu.kaua.helpencontro.dto.request.auth.LoginRequest;
import edu.kaua.helpencontro.dto.request.auth.SignupRequest;
import edu.kaua.helpencontro.dto.response.JwtResponse;
import edu.kaua.helpencontro.dto.response.MessageResponse;
import edu.kaua.helpencontro.services.users.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authenticateUser(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return ResponseEntity.ok(authService.registerUser(signUpRequest));
    }
}
