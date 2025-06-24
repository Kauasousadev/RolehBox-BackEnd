package edu.kaua.helpencontro.services.mappers.mapperrequestdto;

import edu.kaua.helpencontro.dto.request.roleh.RolehRequestDTO;
import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.TipoComida;
import edu.kaua.helpencontro.repositories.roleh.TipoComidaRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ComidaMapper implements Function<RolehRequestDTO.ComidaRequestDTO, TipoComida> {

    private final TipoComidaRepository tipoComidaRepository;

    public ComidaMapper(TipoComidaRepository tipoComidaRepository) {
        this.tipoComidaRepository = tipoComidaRepository;
    }

    @Override
    public TipoComida apply(RolehRequestDTO.ComidaRequestDTO comidaRequestDTO) {
        TipoComida newComida = new TipoComida(comidaRequestDTO.getDescription());
        tipoComidaRepository.save(newComida);
        return newComida;
    }
}