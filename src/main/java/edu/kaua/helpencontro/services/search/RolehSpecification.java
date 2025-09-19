package edu.kaua.helpencontro.services.search;

import edu.kaua.helpencontro.models.roleh.Roleh;
import edu.kaua.helpencontro.models.roleh.tagsrole.CaracteristicaRole;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.*;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

public class RolehSpecification {

    public static Specification<Roleh> comNome(String nome) {
        return (root, query, criteriaBuilder) -> {
            if (nome == null || nome.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + nome.toLowerCase() + "%");
        };
    }

    public static Specification<Roleh> comTipoComida(Set<String> tiposComida) {
        return (root, query, criteriaBuilder) -> {
            if (tiposComida == null || tiposComida.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Roleh, CaracteristicaRole> caracteristicaJoin = root.join("caracteristicas");
            Join<CaracteristicaRole, TipoComida> comidaJoin = caracteristicaJoin.join("comidas");
            return comidaJoin.get("description").in(tiposComida);
        };
    }

    public static Specification<Roleh> comTipoMusica(Set<String> tiposMusica) {
        return (root, query, criteriaBuilder) -> {
            if (tiposMusica == null || tiposMusica.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Roleh, CaracteristicaRole> caracteristicaJoin = root.join("caracteristicas");
            Join<CaracteristicaRole, TipoMusica> musicaJoin = caracteristicaJoin.join("musicas");
            return musicaJoin.get("description").in(tiposMusica);
        };
    }

    public static Specification<Roleh> comTipoAcessibilidade(Set<String> tiposAcessibilidade) {
        return (root, query, criteriaBuilder) -> {
            if (tiposAcessibilidade == null || tiposAcessibilidade.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Roleh, CaracteristicaRole> caracteristicaJoin = root.join("caracteristicas");
            Join<CaracteristicaRole, TipoAcessibilidade> acessibilidadeJoin = caracteristicaJoin.join("acessibilidades");
            return acessibilidadeJoin.get("description").in(tiposAcessibilidade);
        };
    }

    public static Specification<Roleh> comOutrasTags(Set<String> outrasTags) {
        return (root, query, criteriaBuilder) -> {
            if (outrasTags == null || outrasTags.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Roleh, CaracteristicaRole> caracteristicaJoin = root.join("caracteristicas");
            Join<CaracteristicaRole, OutrasTags> tagsJoin = caracteristicaJoin.join("outrasTags");
            return tagsJoin.get("description").in(outrasTags);
        };
    }

    public static Specification<Roleh> comTipoLocal(String tipoLocal) {
        return (root, query, criteriaBuilder) -> {
            if (tipoLocal == null || tipoLocal.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Roleh, CaracteristicaRole> caracteristicaJoin = root.join("caracteristicas");
            Join<CaracteristicaRole, TipoLocal> localJoin = caracteristicaJoin.join("tipoLocal");
            return criteriaBuilder.equal(localJoin.get("description"), tipoLocal);
        };
    }

    public static Specification<Roleh> comPrecoEntre(Float minPrice, Float maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            Join<Roleh, CaracteristicaRole> caracteristicaJoin = root.join("caracteristicas");

            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(caracteristicaJoin.get("minPrice"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(caracteristicaJoin.get("minPrice"), minPrice);
            } else { // maxPrice != null
                return criteriaBuilder.lessThanOrEqualTo(caracteristicaJoin.get("maxPrice"), maxPrice);
            }
        };
    }

    //Adicionar filtro de localização e rating de reviews
}