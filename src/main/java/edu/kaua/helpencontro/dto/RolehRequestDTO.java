package edu.kaua.helpencontro.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolehRequestDTO {
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    @Getter
    private CaracteristicaRequestDTO caracteristicas;

    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class CaracteristicaRequestDTO {
        private String gMapsLink;
        private String instaUser;
        private Float minPrice;
        private Float maxPrice;
        private LocalDateTime closingHours;
        private LocalDateTime openingHours;
        private Long localId;
        @Getter
        private List<ComidaRequestDTO> comidas;
        @Getter
        private List<MusicaRequestDTO> musicas;
        @Getter
        private List<AcessibilidadeRequestDTO> acessibilidades;
        @Getter
        private List<OutrasTagsRequestDTO> outrasTags;

    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ComidaRequestDTO {
        private String description;

        // Getters e Setters
        public String getdescription() {
            return description;
        }

        public void setdescription(String description) {
            this.description = description;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MusicaRequestDTO {
        private String description;

        public String getdescription() {
            return description;
        }

        public void setdescription(String description) {
            this.description = description;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AcessibilidadeRequestDTO {
        private String description;

        public String getdescription() {
            return description;
        }

        public void setdescription(String description) {
            this.description = description;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OutrasTagsRequestDTO {
        private String description;

        public String getdescription() {
            return description;
        }

        public void setdescription(String description) {
            this.description = description;
        }
    }
}