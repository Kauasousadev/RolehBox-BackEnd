package edu.kaua.helpencontro.services.mappers.mapperrequestdto;

import edu.kaua.helpencontro.dto.request.roleh.RolehRequestDTO;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.TipoMusica;
import edu.kaua.helpencontro.repositories.roleh.TipoMusicaRepository;
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