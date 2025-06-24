package edu.kaua.helpencontro.dto.request.roleh;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class RolehRequestDTO {
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    @Getter
    private CaracteristicaRequestDTO caracteristicas;

    @Data
    @RequiredArgsConstructor
    public static class CaracteristicaRequestDTO {
        private String googleMapsLink;
        private String instaUser;
        private Float minPrice;
        private Float maxPrice;
        private LocalDateTime closingHours;
        private LocalDateTime openingHours;

        private Long localId;

        @Getter
        private Set<ComidaRequestDTO> comidas;
        @Getter
        private Set<MusicaRequestDTO> musicas;
        @Getter
        private Set<AcessibilidadeRequestDTO> acessibilidades;
        @Getter
        private Set<OutrasTagsRequestDTO> outrasTags;
    }

    @Data
    @RequiredArgsConstructor
    public static class ComidaRequestDTO {
        private String description;
    }

    @Data
    @RequiredArgsConstructor
    public static class MusicaRequestDTO {
        private String description;
    }

    @Data
    @RequiredArgsConstructor
    public static class AcessibilidadeRequestDTO {
        private String description;
    }

    @Data
    @RequiredArgsConstructor
    public static class OutrasTagsRequestDTO {
        private String description;
    }
}