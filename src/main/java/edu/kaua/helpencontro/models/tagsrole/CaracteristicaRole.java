package edu.kaua.helpencontro.models.tagsrole;

import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CaracteristicaRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String gMapsLink;
    @Column()
    private String instaUser;
    @Column()
    private Float minPrice;
    @Column()
    private Float maxPrice;
    @Column()
    private LocalDateTime openingHours;
    @Column()
    private LocalDateTime closingHours;


    @OneToOne
    @JoinColumn(name = "roleh_id")
    private Roleh roleh;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private TipoLocal tipoLocal;

    @OneToMany(mappedBy = "caracteristica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TipoComida> comidas = new ArrayList<>();

    @OneToMany(mappedBy = "caracteristica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TipoMusica> musicas = new ArrayList<>();

    @OneToMany(mappedBy = "caracteristica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TipoAcessibilidade> acessibilidade = new ArrayList<>();

    @OneToMany(mappedBy = "caracteristica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutrasTags> outrasTags = new ArrayList<>();


    public CaracteristicaRole() {
    }

    public CaracteristicaRole(String gMapsLink, String instaUser, Float minPrice, Float maxPrice, LocalDateTime openingHours, LocalDateTime closingHours, Roleh roleh, TipoLocal tipoLocal, List<TipoComida> comidas, List<TipoMusica> musicas, List<TipoAcessibilidade> acessibilidade, List<OutrasTags> outrasTags) {
        this.gMapsLink = gMapsLink;
        this.instaUser = instaUser;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.roleh = roleh;
        this.tipoLocal = tipoLocal;
        this.comidas = comidas;
        this.musicas = musicas;
        this.acessibilidade = acessibilidade;
        this.outrasTags = outrasTags;
    }

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

    public LocalDateTime getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(LocalDateTime openingHours) {
        this.openingHours = openingHours;
    }

    public LocalDateTime getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(LocalDateTime closingHours) {
        this.closingHours = closingHours;
    }

    public Roleh getRoleh() {
        return roleh;
    }

    public void setRoleh(Roleh roleh) {
        this.roleh = roleh;
    }

    public TipoLocal getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(TipoLocal tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public List<TipoComida> getComidas() {
        return comidas;
    }

    public void setComidas(List<TipoComida> comidas) {
        this.comidas = comidas;
    }

    public List<TipoMusica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<TipoMusica> musicas) {
        this.musicas = musicas;
    }

    public List<TipoAcessibilidade> getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(List<TipoAcessibilidade> acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public List<OutrasTags> getOutrasTags() {
        return outrasTags;
    }

    public void setOutrasTags(List<OutrasTags> outrasTags) {
        this.outrasTags = outrasTags;
    }
}