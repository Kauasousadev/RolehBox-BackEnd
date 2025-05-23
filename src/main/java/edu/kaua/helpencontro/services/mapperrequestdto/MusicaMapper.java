package edu.kaua.helpencontro.services.mapperrequestdto;

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
    public TipoMusica apply(RolehRequestDTO.MusicaRequestDTO musicaRequestDTO) {
        TipoMusica newMusica = new TipoMusica(musicaRequestDTO.getDescription());
        tipoMusicaRepository.save(newMusica);
        return newMusica;
    }
}