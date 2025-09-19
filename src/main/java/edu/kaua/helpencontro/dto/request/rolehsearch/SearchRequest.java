package edu.kaua.helpencontro.dto.request.rolehsearch;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SearchRequest {

    private String name;
    private Set<String> tiposComida;
    private Set<String> tiposMusica;
    private Set<String> tiposAcessibilidade;
    private Set<String> outrasTags;
    private String tipoLocal;
    private Float minPrice;
    private Float maxPrice;
    //Adicionar endereço e rating das reviews
}