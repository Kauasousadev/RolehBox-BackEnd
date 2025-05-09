package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AcessibilidadeMapper {
    AcessibilidadeMapper INSTANCE = Mappers.getMapper(AcessibilidadeMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "caracteristica", ignore = true)
    TipoAcessibilidade toEntity(RolehRequestDTO.MusicaRequestDTO dto);

    RolehResponseDTO.MusicaResponseDTO toResponseDTO(TipoAcessibilidade entity);

    List<TipoAcessibilidade> toEntityList(List<RolehRequestDTO.MusicaRequestDTO> dtos);
    List<RolehResponseDTO.MusicaResponseDTO> toResponseDTOList(List<TipoAcessibilidade> entities);
}