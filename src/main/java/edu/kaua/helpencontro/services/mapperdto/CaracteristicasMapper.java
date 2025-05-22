package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.*;
import edu.kaua.helpencontro.repositories.TipoLocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CaracteristicasMapper implements Function<RolehRequestDTO.CaracteristicaRequestDTO, CaracteristicaRole> {
    private final ComidaMapper comidaMapper;
    private final MusicaMapper musicaMapper;
    private final AcessibilidadeMapper acessibilidadeMapper;
    private final OutrasTagsMapper outrasTagsMapper;
    private final TipoLocalRepository tipoLocalRepository;

    @Autowired
    public CaracteristicasMapper(ComidaMapper comidaMapper,
                                 MusicaMapper musicaMapper,
                                 AcessibilidadeMapper acessibilidadeMapper,
                                 OutrasTagsMapper outrasTagsMapper, TipoLocalRepository tipoLocalRepository) {
        this.comidaMapper = comidaMapper;
        this.musicaMapper = musicaMapper;
        this.acessibilidadeMapper = acessibilidadeMapper;
        this.outrasTagsMapper = outrasTagsMapper;
        this.tipoLocalRepository = tipoLocalRepository;
    }

    @Override
    public CaracteristicaRole apply(RolehRequestDTO.CaracteristicaRequestDTO caracteristicaRequestDTO) {
        if (caracteristicaRequestDTO == null) {
            return null;
        }

        CaracteristicaRole caracteristica = new CaracteristicaRole();

        // Mapeando campos básicos
        caracteristica.setGMapsLink(caracteristicaRequestDTO.getGMapsLink());
        caracteristica.setInstaUser(caracteristicaRequestDTO.getInstaUser());
        caracteristica.setMinPrice(caracteristicaRequestDTO.getMinPrice());
        caracteristica.setMaxPrice(caracteristicaRequestDTO.getMaxPrice());
        caracteristica.setOpeningHours(caracteristicaRequestDTO.getOpeningHours());
        caracteristica.setClosingHours(caracteristicaRequestDTO.getClosingHours());

        // Mapeando tipo local
        caracteristica.setTipoLocal(getTipoLocal(caracteristicaRequestDTO.getLocalId()));

        // Mapeando listas com relacionamentos many-to-many
        mapComidas(caracteristica, caracteristicaRequestDTO.getComidas());
        //mapMusicas(caracteristica, caracteristicaRequestDTO.getMusicas());
        //mapAcessibilidades(caracteristica, caracteristicaRequestDTO.getAcessibilidades());
        //mapOutrasTags(caracteristica, caracteristicaRequestDTO.getOutrasTags());

        return caracteristica;
    }

    private TipoLocal getTipoLocal(Long id){
        return tipoLocalRepository.getById(id);
    }

    private void mapComidas(CaracteristicaRole caracteristica, List<RolehRequestDTO.ComidaRequestDTO> comidas) {
        if (comidas == null || comidas.isEmpty()) return;

        Set<TipoComida> comidasMapeadas = comidas.stream()
                .map(comidaMapper)
                .collect(Collectors.toSet());

        // Atualiza ambos os lados do relacionamento
        caracteristica.setComidas(comidasMapeadas);
        comidasMapeadas.forEach(comida ->
                comida.getCaracteristicaRole().add(caracteristica)
        );
    }

    private void mapMusicas(CaracteristicaRole caracteristica, List<RolehRequestDTO.MusicaRequestDTO> musicas) {
        if (musicas == null || musicas.isEmpty()) return;

        Set<TipoMusica> musicasMapeadas = musicas.stream()
                .map(musicaMapper)
                .peek(musica -> {
                    if (musica.getCaracteristicaRole() == null) {
                        musica.setCaracteristicaRole(new HashSet<>());
                    }
                    musica.getCaracteristicaRole().add(caracteristica);
                })
                .collect(Collectors.toSet());

        caracteristica.setMusicas(musicasMapeadas);
    }

    private void mapAcessibilidades(CaracteristicaRole caracteristica, List<RolehRequestDTO.AcessibilidadeRequestDTO> acessibilidades) {
        if (acessibilidades == null || acessibilidades.isEmpty()) return;

        Set<TipoAcessibilidade> acessibilidadesMapeadas = acessibilidades.stream()
                .map(acessibilidadeMapper)
                .peek(acessibilidade -> {
                    if (acessibilidade.getCaracteristicaRole() == null) {
                        acessibilidade.setCaracteristicaRole(new HashSet<>());
                    }
                    acessibilidade.getCaracteristicaRole().add(caracteristica);
                })
                .collect(Collectors.toSet());

        caracteristica.setAcessibilidade(acessibilidadesMapeadas);
    }

    private void mapOutrasTags(CaracteristicaRole caracteristica, List<RolehRequestDTO.OutrasTagsRequestDTO> outrasTags) {
        if (outrasTags == null || outrasTags.isEmpty()) return;

        Set<OutrasTags> outrasTagsMapeadas = outrasTags.stream()
                .map(outrasTagsMapper)
                .peek(outraTag -> {
                    if (outraTag.getCaracteristicaRole() == null) {
                        outraTag.setCaracteristicaRole(new HashSet<>());
                    }
                    outraTag.getCaracteristicaRole().add(caracteristica);
                })
                .collect(Collectors.toSet());

        caracteristica.setOutrasTags(outrasTagsMapeadas);
    }
}