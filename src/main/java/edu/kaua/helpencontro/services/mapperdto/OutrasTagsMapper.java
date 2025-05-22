package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.OutrasTags;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OutrasTagsMapper implements Function<RolehRequestDTO.OutrasTagsRequestDTO, OutrasTags> {

    @Override
    public OutrasTags apply(RolehRequestDTO.OutrasTagsRequestDTO OutrasTagsRequestDTO) {
        return new OutrasTags(
                OutrasTagsRequestDTO.getdescription()
        );
    }
}