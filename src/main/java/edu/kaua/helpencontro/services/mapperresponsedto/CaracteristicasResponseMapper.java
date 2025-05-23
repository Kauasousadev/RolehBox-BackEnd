package edu.kaua.helpencontro.services.mapperresponsedto;

import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoComida;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoMusica;
import edu.kaua.helpencontro.repositories.TipoLocalRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CaracteristicasResponseMapper implements Function<CaracteristicaRole, RolehResponseDTO.CaracteristicaResponseDTO> {
    private final ComidaResponseMapper comidaResponseMapper = new ComidaResponseMapper();
    private final MusicaResponseMapper musicaResponseMapper = new MusicaResponseMapper();
    private final TipoLocalRepository tipoLocalRepository;
    private final AcessibilidadeResponseMapper acessibilidadeResponseMapper;

    public CaracteristicasResponseMapper(TipoLocalRepository tipoLocalRepository, AcessibilidadeResponseMapper acessibilidadeResponseMapper) {
        this.tipoLocalRepository = tipoLocalRepository;
        this.acessibilidadeResponseMapper = acessibilidadeResponseMapper;
    }

    @Override
    public RolehResponseDTO.CaracteristicaResponseDTO apply(CaracteristicaRole caracteristicaRole) {
        RolehResponseDTO.CaracteristicaResponseDTO caracteristicasResponseDTO = new RolehResponseDTO.CaracteristicaResponseDTO();

        caracteristicasResponseDTO.setGoogleMapsLink(caracteristicaRole.getGoogleMapsLink());
        caracteristicasResponseDTO.setInstaUser(caracteristicaRole.getInstaUser());
        caracteristicasResponseDTO.setMinPrice(caracteristicaRole.getMinPrice());
        caracteristicasResponseDTO.setMaxPrice(caracteristicaRole.getMaxPrice());
        caracteristicasResponseDTO.setOpeningHours(caracteristicaRole.getOpeningHours());
        caracteristicasResponseDTO.setClosingHours(caracteristicaRole.getClosingHours());
        caracteristicasResponseDTO.setTipoLocal(getTipoLocal(caracteristicaRole.getTipoLocal().getId()));
        caracteristicasResponseDTO.setComidas(mapComidas(caracteristicaRole.getComidas()));
        caracteristicasResponseDTO.setMusicas(mapMusicas(caracteristicaRole.getMusicas()));
        caracteristicasResponseDTO.setAcessibilidades(mapAcessibilidade(caracteristicaRole.getAcessibilidades()));

        return caracteristicasResponseDTO;
    }

    private Set<RolehResponseDTO.ComidaResponseDTO> mapComidas(Set<TipoComida> comidas) {
        if (comidas == null || comidas.isEmpty()) return null;

        Set<RolehResponseDTO.ComidaResponseDTO> comidasMapeadas = comidas.stream()
                .map(comidaResponseMapper)
                .collect(Collectors.toSet());

        return comidasMapeadas;
    }

    private Set<RolehResponseDTO.MusicaResponseDTO> mapMusicas(Set<TipoMusica> musicas) {
        if (musicas == null || musicas.isEmpty()) return null;

        Set<RolehResponseDTO.MusicaResponseDTO> musicasMapeadas = musicas.stream()
                .map(musicaResponseMapper)
                .collect(Collectors.toSet());

        return musicasMapeadas;

    }

    private Set<RolehResponseDTO.AcessibilidadeResponseDTO> mapAcessibilidade(Set<TipoAcessibilidade> acessibilidades) {
        if (acessibilidades == null || acessibilidades.isEmpty()) return null;

        Set<RolehResponseDTO.AcessibilidadeResponseDTO> acessibilidadesMapeadas = acessibilidades.stream()
                .map(acessibilidadeResponseMapper)
                .collect(Collectors.toSet());

        return acessibilidadesMapeadas;

    }

    private String getTipoLocal(Long id){
        if (tipoLocalRepository.existsById(id)) {
            return tipoLocalRepository.findById(id).get().getDescription();
        }
        return null;
    }
}
