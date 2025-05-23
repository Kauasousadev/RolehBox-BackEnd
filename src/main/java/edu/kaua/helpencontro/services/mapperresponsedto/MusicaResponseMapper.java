package edu.kaua.helpencontro.services.mapperresponsedto;

import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoMusica;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MusicaResponseMapper implements Function<TipoMusica, RolehResponseDTO.MusicaResponseDTO> {
    @Override
    public RolehResponseDTO.MusicaResponseDTO apply(TipoMusica tipoMusica) {
        RolehResponseDTO.MusicaResponseDTO musicaResponseDTO = new RolehResponseDTO.MusicaResponseDTO();

        musicaResponseDTO.setDescription(tipoMusica.getDescription());

        return musicaResponseDTO;
    }
}
