package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoMusica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MusicaMapper {
    MusicaMapper INSTANCE = Mappers.getMapper(MusicaMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "caracteristica", ignore = true)
    TipoMusica toEntity(RolehRequestDTO.MusicaRequestDTO dto);

    RolehResponseDTO.MusicaResponseDTO toResponseDTO(TipoMusica entity);

    List<TipoMusica> toEntityList(List<RolehRequestDTO.MusicaRequestDTO> dtos);
    List<RolehResponseDTO.MusicaResponseDTO> toResponseDTOList(List<TipoMusica> entities);
}
