package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.OutrasTags;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoComida;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoMusica;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ListMapperService {
    private final ComidaMapper comidaMapper;
    private final MusicaMapper musicaMapper;
    private final AcessibilidadeMapper acessibilidadeMapper;
    private final OutrasTagsMapper outrasTagsMapper;

    public List<?> listMapper(List<?> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            return Collections.emptyList();
        }

        Object firstElement = dtoList.get(0);

        if (firstElement instanceof RolehRequestDTO.ComidaRequestDTO) {
            return mapComidas(dtoList);
        } else if (firstElement instanceof RolehRequestDTO.MusicaRequestDTO) {
            return mapMusicas(dtoList);
        } else if (firstElement instanceof RolehRequestDTO.AcessibilidadeRequestDTO) {
            return mapAcessibilidades(dtoList);
        } else if (firstElement instanceof RolehRequestDTO.OutrasTagsRequestDTO) {
            return mapOutrasTags(dtoList);
        } else {
            throw new IllegalArgumentException("Tipo de DTO não suportado: " + firstElement.getClass());
        }
    }

    private List<TipoComida> mapComidas(List<?> dtoList) {
        return dtoList.stream()
                .map(dto -> {
                    TipoComida comida = comidaMapper.apply((RolehRequestDTO.ComidaRequestDTO) dto);
                    comida.setCaracteristicaRole(new HashSet<>()); // Inicializa o conjunto
                    return comida;
                })
                .toList();
    }

    private List<TipoMusica> mapMusicas(List<?> dtoList) {
        return dtoList.stream()
                .map(dto -> {
                    TipoMusica musica = musicaMapper.apply((RolehRequestDTO.MusicaRequestDTO) dto);
                    musica.setCaracteristicaRole(new HashSet<>());
                    return musica;
                })
                .toList();
    }

    private List<TipoAcessibilidade> mapAcessibilidades(List<?> dtoList) {
        return dtoList.stream()
                .map(dto -> {
                    TipoAcessibilidade acessibilidade = acessibilidadeMapper.apply((RolehRequestDTO.AcessibilidadeRequestDTO) dto);
                    acessibilidade.setCaracteristicaRole(new HashSet<>());
                    return acessibilidade;
                })
                .toList();
    }

    private List<OutrasTags> mapOutrasTags(List<?> dtoList) {
        return dtoList.stream()
                .map(dto -> {
                    OutrasTags outraTag = outrasTagsMapper.apply((RolehRequestDTO.OutrasTagsRequestDTO) dto);
                    outraTag.setCaracteristicaRole(new HashSet<>());
                    return outraTag;
                })
                .toList();
    }
}