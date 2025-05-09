package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoLocal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocalMapper {
    LocalMapper INSTANCE = Mappers.getMapper(LocalMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "descricao", source = "descricao")
    RolehResponseDTO.LocalResponseDTO toResponseDTO(TipoLocal local);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "descricao", source = "descricao")
    TipoLocal toEntity(RolehResponseDTO.LocalResponseDTO dto);
}