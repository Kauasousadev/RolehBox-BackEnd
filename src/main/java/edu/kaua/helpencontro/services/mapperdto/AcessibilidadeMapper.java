package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AcessibilidadeMapper implements Function<RolehRequestDTO.AcessibilidadeRequestDTO, TipoAcessibilidade> {

    @Override
    public TipoAcessibilidade apply(RolehRequestDTO.AcessibilidadeRequestDTO AcessibilidadeRequestDTO) {
        return new TipoAcessibilidade(
                AcessibilidadeRequestDTO.getdescription()
        );
    }
}