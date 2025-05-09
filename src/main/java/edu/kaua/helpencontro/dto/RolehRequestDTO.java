package edu.kaua.helpencontro.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RolehRequestDTO {
    private String name;
    private String desc;
    private String address;
    private String phoneNumber;
    private CaracteristicaRequestDTO caracteristicas;

    // Getters e Setters (Obrigatórios para desserialização JSON)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CaracteristicaRequestDTO getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(CaracteristicaRequestDTO caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public static class CaracteristicaRequestDTO {
        private String gMapsLink;
        private String instaUser;
        private Float minPrice;
        private Float maxPrice;
        private LocalDateTime closingHours;
        private LocalDateTime openingHours;
        private Long localId; // ID do Local (em vez do objeto completo)
        private List<ComidaRequestDTO> comidas;
        private List<MusicaRequestDTO> musicas;
        private List<AcessibilidadeRequestDTO> acessibilidades;
        private List<OutrasTagsRequestDTO> outrasTags;

        // Getters e Setters

        public String getgMapsLink() {
            return gMapsLink;
        }

        public void setgMapsLink(String gMapsLink) {
            this.gMapsLink = gMapsLink;
        }

        public String getInstaUser() {
            return instaUser;
        }

        public void setInstaUser(String instaUser) {
            this.instaUser = instaUser;
        }

        public Float getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(Float minPrice) {
            this.minPrice = minPrice;
        }

        public Float getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(Float maxPrice) {
            this.maxPrice = maxPrice;
        }

        public LocalDateTime getClosingHours() {
            return closingHours;
        }

        public void setClosingHours(LocalDateTime closingHours) {
            this.closingHours = closingHours;
        }

        public LocalDateTime getOpeningHours() {
            return openingHours;
        }

        public void setOpeningHours(LocalDateTime openingHours) {
            this.openingHours = openingHours;
        }

        public Long getLocalId() {
            return localId;
        }

        public void setLocalId(Long localId) {
            this.localId = localId;
        }

        public List<ComidaRequestDTO> getComidas() {
            return comidas;
        }

        public void setComidas(List<ComidaRequestDTO> comidas) {
            this.comidas = comidas;
        }

        public List<MusicaRequestDTO> getMusicas() {
            return musicas;
        }

        public void setMusicas(List<MusicaRequestDTO> musicas) {
            this.musicas = musicas;
        }

        public List<AcessibilidadeRequestDTO> getAcessibilidades() {
            return acessibilidades;
        }

        public void setAcessibilidades(List<AcessibilidadeRequestDTO> acessibilidades) {
            this.acessibilidades = acessibilidades;
        }

        public List<OutrasTagsRequestDTO> getOutrasTags() {
            return outrasTags;
        }

        public void setOutrasTags(List<OutrasTagsRequestDTO> outrasTags) {
            this.outrasTags = outrasTags;
        }
    }

    public static class ComidaRequestDTO {
        private String descricao;

        // Getters e Setters
        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }

    public static class MusicaRequestDTO {
        private String descricao;

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }

    public static class AcessibilidadeRequestDTO {
        private String descricao;

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }

    public static class OutrasTagsRequestDTO {
        private String descricao;

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }
}