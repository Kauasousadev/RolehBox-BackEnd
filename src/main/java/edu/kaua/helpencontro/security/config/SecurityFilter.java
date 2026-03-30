package edu.kaua.helpencontro.security.config;

import edu.kaua.helpencontro.repositories.user.UserRepository;
import edu.kaua.helpencontro.security.jwt.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. Tenta extrair o token do cabeçalho da requisição
        var token = this.recoverToken(request);

        // 2. Se houver um token, vamos validá-lo
        if (token != null) {
            var login = tokenService.validateToken(token); // Retorna o e-mail se for válido

            // 3. Se o token for válido (login não for vazio), buscamos o usuário
            if (!login.isEmpty()) {
                UserDetails user = userRepository.findByEmail(login);

                // 4. Criamos o objeto de autenticação do Spring e forçamos a autenticação no contexto
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // 5. Continua o fluxo da requisição (passa para o próximo filtro ou para o Controller)
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;

        // O padrão de mercado é enviar o token como "Bearer eyJhbGci..."
        // Então nós removemos a palavra "Bearer " para pegar só o token JWT
        return authHeader.replace("Bearer ", "");
    }
}