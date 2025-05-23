package edu.kaua.helpencontro.services.mapperrequestdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.OutrasTags;
import edu.kaua.helpencontro.repositories.OutrasTagsRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OutrasTagsMapper implements Function<RolehRequestDTO.OutrasTagsRequestDTO, OutrasTags> {

    private final OutrasTagsRepository outrasTagsRepository;

    public OutrasTagsMapper(OutrasTagsRepository outrasTagsRepository) {
        this.outrasTagsRepository = outrasTagsRepository;
    }

    @Override
    public OutrasTags apply(RolehRequestDTO.OutrasTagsRequestDTO outrasTagsRequestDTO) {
        OutrasTags newOutrasTags = new OutrasTags(outrasTagsRequestDTO.getDescription());
        outrasTagsRepository.save(newOutrasTags);
        return newOutrasTags;
    }
}