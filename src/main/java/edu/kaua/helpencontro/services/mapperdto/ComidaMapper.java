package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoComida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ComidaMapper {
    ComidaMapper INSTANCE = Mappers.getMapper(ComidaMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "caracteristica", ignore = true)
    TipoComida toEntity(RolehRequestDTO.ComidaRequestDTO dto);

    RolehResponseDTO.ComidaResponseDTO toResponseDTO(TipoComida entity);

    // Mapeamento de lista
    List<TipoComida> toEntityList(List<RolehRequestDTO.ComidaRequestDTO> dtos);
    List<RolehResponseDTO.ComidaResponseDTO> toResponseDTOList(List<TipoComida> entities);
}
