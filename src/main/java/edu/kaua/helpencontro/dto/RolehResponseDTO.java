package edu.kaua.helpencontro.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RolehResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private CaracteristicaResponseDTO caracteristicas;

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

    public static class LocalResponseDTO {
        private Long id;
        private String descricao;
    }

    public static class ComidaResponseDTO {
        private Long id;
        private String descricao;
    }

    public static class MusicaResponseDTO {
        private Long id;
        private String descricao;
    }

    public static class AcessibilidadeResponseDTO {
        private Long id;
        private String descricao;
    }

    public static class OutrasTagsResponseDTO {
        private Long id;
        private String descricao;
    }

}
