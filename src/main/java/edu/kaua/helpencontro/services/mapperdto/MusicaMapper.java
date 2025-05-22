package edu.kaua.helpencontro.services.mapperdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoMusica;
import edu.kaua.helpencontro.repositories.TipoMusicaRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MusicaMapper implements Function<RolehRequestDTO.MusicaRequestDTO, TipoMusica> {

    private final TipoMusicaRepository tipoMusicaRepository;

    public MusicaMapper(TipoMusicaRepository tipoMusicaRepository) {
        this.tipoMusicaRepository = tipoMusicaRepository;
    }

    @Override
    public TipoMusica apply(RolehRequestDTO.MusicaRequestDTO MusicaRequestDTO) {
        TipoMusica newMusica = new TipoMusica(MusicaRequestDTO.getdescription());
        tipoMusicaRepository.save(newMusica);
        return new TipoMusica(
                MusicaRequestDTO.getdescription()
        );
    }
}