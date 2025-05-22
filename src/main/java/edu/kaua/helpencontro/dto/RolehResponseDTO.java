package edu.kaua.helpencontro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolehResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private CaracteristicaResponseDTO caracteristicas;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CaracteristicaResponseDTO {
        private String gMapsLink;
        private String instaUser;
        private Float minPrice;
        private Float maxPrice;
        private LocalDateTime closingHours;
        private LocalDateTime openingHours;
        private LocalResponseDTO tipoLocal; // Objeto aninhado (não apenas ID)
        private List<OutrasTagsResponseDTO> comidas;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LocalResponseDTO {
        private Long id;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ComidaResponseDTO {
        private Long id;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MusicaResponseDTO {
        private Long id;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AcessibilidadeResponseDTO {
        private Long id;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OutrasTagsResponseDTO {
        private Long id;
        private String description;
    }
}
