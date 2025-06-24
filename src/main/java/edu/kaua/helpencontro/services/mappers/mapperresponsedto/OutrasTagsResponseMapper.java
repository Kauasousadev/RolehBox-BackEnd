package edu.kaua.helpencontro.services.mappers.mapperresponsedto;

import edu.kaua.helpencontro.dto.response.roleh.RolehResponseDTO;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.OutrasTags;
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
