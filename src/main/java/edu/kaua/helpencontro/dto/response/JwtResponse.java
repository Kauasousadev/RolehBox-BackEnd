package edu.kaua.helpencontro.dto.response;

public record JwtResponse(
        String token,
        String username
) {}
