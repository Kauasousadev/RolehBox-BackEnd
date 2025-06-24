package edu.kaua.helpencontro.services.mappers.mapperresponsedto;

import edu.kaua.helpencontro.dto.response.roleh.RolehResponseDTO;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.TipoComida;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ComidaResponseMapper implements Function<TipoComida, RolehResponseDTO.ComidaResponseDTO> {
    @Override
    public RolehResponseDTO.ComidaResponseDTO apply(TipoComida tipoComida) {
        RolehResponseDTO.ComidaResponseDTO comidaResponseDTO = new RolehResponseDTO.ComidaResponseDTO();

        comidaResponseDTO.setDescription(tipoComida.getDescription());

        return comidaResponseDTO;
    }
}
