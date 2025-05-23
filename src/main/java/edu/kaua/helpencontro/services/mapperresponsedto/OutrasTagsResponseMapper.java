package edu.kaua.helpencontro.services.mapperresponsedto;

import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.OutrasTags;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoMusica;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OutrasTagsResponseMapper implements Function<OutrasTags, RolehResponseDTO.OutrasTagsResponseDTO> {
    @Override
    public RolehResponseDTO.OutrasTagsResponseDTO apply(OutrasTags outrasTags) {
        RolehResponseDTO.OutrasTagsResponseDTO outrasTagsResponseDTO = new RolehResponseDTO.OutrasTagsResponseDTO();

        outrasTagsResponseDTO.setDescription(outrasTags.getDescription());

        return outrasTagsResponseDTO;
    }
}
