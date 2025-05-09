package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoLocal;
import edu.kaua.helpencontro.services.mapperdto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {LocalMapper.class, ComidaMapper.class, MusicaMapper.class,
        AcessibilidadeMapper.class, OutrasTagsMapper.class})
public interface RolehMapper {

    RolehMapper INSTANCE = Mappers.getMapper(RolehMapper.class);

    // Request DTO → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "caracteristicas.roleh", ignore = true)
    Roleh toEntity(RolehRequestDTO dto);

    // Entity → Response DTO
    RolehResponseDTO toResponseDTO(Roleh entity);

    // Mapeamento de Caracteristicas com listas
    @Mapping(target = "comidas", source = "comidas")
    @Mapping(target = "musicas", source = "musicas")
    @Mapping(target = "acessibilidades", source = "acessibilidades")
    @Mapping(target = "outrasTags", source = "outrasTags")
    @Mapping(target = "localId", source = "tipoLocal.id")
    RolehResponseDTO.CaracteristicaResponseDTO mapCaracteristica(CaracteristicaRole caracteristica);
}