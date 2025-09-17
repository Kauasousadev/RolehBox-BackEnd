package edu.kaua.helpencontro.dto.request.rolehsearch;

import edu.kaua.helpencontro.models.roleh.Roleh;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class RolehSearchDTO {
    private String googleMapsLink;
    private String instaUser;
    private Float minPrice;
    private Float maxPrice;
    private LocalDateTime openingHours;
    private LocalDateTime closingHours;
    private TipoLocal tipoLocal;

    private Set<TipoComida> comidas = new HashSet<>();

    private Set<TipoMusica> musicas = new HashSet<>();

    private Set<TipoAcessibilidade> acessibilidades = new HashSet<>();

    private Set<OutrasTags> outrasTags = new HashSet<>();
}
