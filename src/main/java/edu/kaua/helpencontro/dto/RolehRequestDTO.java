package edu.kaua.helpencontro.dto;

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
    }

    @Data
    @RequiredArgsConstructor
    public static class ComidaRequestDTO {
        private String description;
    }

}