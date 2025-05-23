package edu.kaua.helpencontro.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class RolehResponseDTO {
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    @Getter
    private CaracteristicaResponseDTO caracteristicas;

    @Data
    @RequiredArgsConstructor
    public static class CaracteristicaResponseDTO {

        private String googleMapsLink;
        private String instaUser;
        private Float minPrice;
        private Float maxPrice;
        private LocalDateTime closingHours;
        private LocalDateTime openingHours;

        private String tipoLocal;

        @Getter
        private Set<ComidaResponseDTO> comidas;
        @Getter
        private Set<MusicaResponseDTO> musicas;
    }

    @Data
    @RequiredArgsConstructor
    public static class ComidaResponseDTO {
        private String description;
    }

    @Data
    @RequiredArgsConstructor
    public static class MusicaResponseDTO {
        private String description;
    }
}
