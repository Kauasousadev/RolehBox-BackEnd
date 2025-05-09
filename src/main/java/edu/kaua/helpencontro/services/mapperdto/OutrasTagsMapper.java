package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.OutrasTags;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OutrasTagsMapper {
    OutrasTagsMapper INSTANCE = Mappers.getMapper(OutrasTagsMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "caracteristica", ignore = true)
    OutrasTags toEntity(RolehRequestDTO.MusicaRequestDTO dto);

    RolehResponseDTO.MusicaResponseDTO toResponseDTO(OutrasTags entity);

    List<OutrasTags> toEntityList(List<RolehRequestDTO.MusicaRequestDTO> dtos);
    List<RolehResponseDTO.MusicaResponseDTO> toResponseDTOList(List<OutrasTags> entities);
}