package edu.kaua.helpencontro.services.mappers.mapperresponsedto;

import edu.kaua.helpencontro.dto.response.roleh.RolehResponseDTO;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AcessibilidadeResponseMapper implements Function<TipoAcessibilidade, RolehResponseDTO.AcessibilidadeResponseDTO> {
    @Override
    public RolehResponseDTO.AcessibilidadeResponseDTO apply(TipoAcessibilidade tipoAcessibilidade) {
        RolehResponseDTO.AcessibilidadeResponseDTO acessibilidadeResponseDTO = new RolehResponseDTO.AcessibilidadeResponseDTO();

        acessibilidadeResponseDTO.setDescription(tipoAcessibilidade.getDescription());

        return acessibilidadeResponseDTO;
    }
}
