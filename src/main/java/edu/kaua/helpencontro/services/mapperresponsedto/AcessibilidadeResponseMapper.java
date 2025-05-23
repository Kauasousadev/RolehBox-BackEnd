package edu.kaua.helpencontro.services.mapperresponsedto;

import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoComida;
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
