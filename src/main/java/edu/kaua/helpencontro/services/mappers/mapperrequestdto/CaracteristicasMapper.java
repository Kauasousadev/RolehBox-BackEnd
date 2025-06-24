package edu.kaua.helpencontro.services.mappers.mapperrequestdto;

import edu.kaua.helpencontro.dto.request.roleh.RolehRequestDTO;
import edu.kaua.helpencontro.models.roleh.Roleh;
import edu.kaua.helpencontro.models.roleh.tagsrole.CaracteristicaRole;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.*;
import edu.kaua.helpencontro.repositories.roleh.TipoLocalRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Service
public class CaracteristicasMapper implements BiFunction<RolehRequestDTO.CaracteristicaRequestDTO, Roleh, CaracteristicaRole> {
    private final ComidaMapper comidaMapper;
    private final MusicaMapper musicaMapper;
    private final AcessibilidadeMapper acessibilidadeMapper;
    //private final OutrasTagsMapper outrasTagsMapper;
    private final TipoLocalRepository tipoLocalRepository;
    private final OutrasTagsMapper outrasTagsMapper;

    public CaracteristicasMapper(ComidaMapper comidaMapper, MusicaMapper musicaMapper, AcessibilidadeMapper acessibilidadeMapper, TipoLocalRepository tipoLocalRepository, @Qualifier("outrasTagsMapper") OutrasTagsMapper outrasTagsMapper) {
        this.comidaMapper = comidaMapper;
        this.musicaMapper = musicaMapper;
        this.acessibilidadeMapper = acessibilidadeMapper;
        this.tipoLocalRepository = tipoLocalRepository;
        this.outrasTagsMapper = outrasTagsMapper;
    }

    @Override
    public CaracteristicaRole apply(RolehRequestDTO.CaracteristicaRequestDTO caracteristicaRequestDTO, Roleh roleh) {
        if (caracteristicaRequestDTO == null) {
            return null;
        }

        CaracteristicaRole caracteristica = new CaracteristicaRole();

        // Mapeando campos básicos
        caracteristica.setGoogleMapsLink(caracteristicaRequestDTO.getGoogleMapsLink());
        caracteristica.setInstaUser(caracteristicaRequestDTO.getInstaUser());
        caracteristica.setMinPrice(caracteristicaRequestDTO.getMinPrice());
        caracteristica.setMaxPrice(caracteristicaRequestDTO.getMaxPrice());
        caracteristica.setOpeningHours(caracteristicaRequestDTO.getOpeningHours());
        caracteristica.setClosingHours(caracteristicaRequestDTO.getClosingHours());

        // Mapeando roleh
        caracteristica.setRoleh(roleh);

        // Mapeando tipo local
        caracteristica.setTipoLocal(getTipoLocal(caracteristicaRequestDTO.getLocalId()));

        // Mapeando listas com relacionamentos many-to-many
        mapComidas(caracteristica, caracteristicaRequestDTO.getComidas());
        mapMusicas(caracteristica, caracteristicaRequestDTO.getMusicas());
        mapAcessibilidades(caracteristica, caracteristicaRequestDTO.getAcessibilidades());
        mapOutrasTags(caracteristica, caracteristicaRequestDTO.getOutrasTags());

        return caracteristica;
    }

    private TipoLocal getTipoLocal(Long id){
        if (tipoLocalRepository.existsById(id)) {
            return tipoLocalRepository.findById(id).get();
        }
        return null;
    }

    private Set<TipoComida> mapComidas(CaracteristicaRole caracteristica, Set<RolehRequestDTO.ComidaRequestDTO> comidas) {
        if (comidas == null || comidas.isEmpty()) return null;

        Set<TipoComida> comidasMapeadas = comidas.stream()
                .map(comidaMapper)
                .collect(Collectors.toSet());

        // Atualiza ambos os lados do relacionamento
        comidasMapeadas.forEach(comida ->
                comida.adicionarCaracteristica(caracteristica)
        );
        return comidasMapeadas;
    }

    private Set<TipoMusica> mapMusicas(CaracteristicaRole caracteristica, Set<RolehRequestDTO.MusicaRequestDTO> musicas) {
        if (musicas == null || musicas.isEmpty()) return null;

        Set<TipoMusica> musicasMapeadas = musicas.stream()
                .map(musicaMapper)
                .collect(Collectors.toSet());

        // Atualiza ambos os lados do relacionamento
        musicasMapeadas.forEach(musica ->
                musica.adicionarCaracteristica(caracteristica)
        );
        return musicasMapeadas;
    }

    private Set<TipoAcessibilidade> mapAcessibilidades(CaracteristicaRole caracteristica, Set<RolehRequestDTO.AcessibilidadeRequestDTO> acessibilidades) {
        if (acessibilidades == null || acessibilidades.isEmpty()) return null;

        Set<TipoAcessibilidade> acessibilidadesMapeadas = acessibilidades.stream()
                .map(acessibilidadeMapper)
                .collect(Collectors.toSet());

        // Atualiza ambos os lados do relacionamento
        acessibilidadesMapeadas.forEach(acessibilidade ->
                acessibilidade.adicionarCaracteristica(caracteristica)
        );
        return acessibilidadesMapeadas;
    }

    private Set<OutrasTags> mapOutrasTags(CaracteristicaRole caracteristica, Set<RolehRequestDTO.OutrasTagsRequestDTO> outrasTags) {
        if (outrasTags == null || outrasTags.isEmpty()) return null;

        Set<OutrasTags> outrasTagsMapeadas = outrasTags.stream()
                .map(outrasTagsMapper)
                .collect(Collectors.toSet());

        // Atualiza ambos os lados do relacionamento
        outrasTagsMapeadas.forEach(outraTag ->
                outraTag.adicionarCaracteristica(caracteristica)
        );
        return outrasTagsMapeadas;
    }
}