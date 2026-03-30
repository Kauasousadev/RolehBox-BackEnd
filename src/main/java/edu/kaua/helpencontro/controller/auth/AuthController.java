package edu.kaua.helpencontro.controller.auth;

import edu.kaua.helpencontro.dto.request.auth.LoginRequest;
import edu.kaua.helpencontro.dto.request.auth.SignupRequest;
import edu.kaua.helpencontro.dto.response.auth.LoginResponseDTO;
import edu.kaua.helpencontro.models.user.User;
import edu.kaua.helpencontro.repositories.user.UserRepository;
import edu.kaua.helpencontro.security.jwt.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequest data) {
        // Cria um token do Spring com o e-mail e senha recebidos
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        // O Spring Security vai no banco verificar se a senha (criptografada) bate
        var auth = this.authenticationManager.authenticate(usernamePassword);

        // Se deu certo, geramos o token JWT
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid SignupRequest data) {
        // Verifica se o e-mail já existe
        if (this.repository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        // Criptografa a senha antes de salvar no banco
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User();
        newUser.setUsername(data.username());
        newUser.setEmail(data.email());
        newUser.setPassword(encryptedPassword);

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}