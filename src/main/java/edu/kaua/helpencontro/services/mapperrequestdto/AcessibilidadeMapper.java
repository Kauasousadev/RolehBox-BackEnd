package edu.kaua.helpencontro.services.mapperrequestdto;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import edu.kaua.helpencontro.repositories.roleh.TipoAcessibilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AcessibilidadeMapper implements Function<RolehRequestDTO.AcessibilidadeRequestDTO, TipoAcessibilidade> {

    private final TipoAcessibilidadeRepository tipoAcessibilidadeRepository;

    public AcessibilidadeMapper(TipoAcessibilidadeRepository tipoAcessibilidadeRepository) {
        this.tipoAcessibilidadeRepository = tipoAcessibilidadeRepository;
    }


    @Override
    public TipoAcessibilidade apply(RolehRequestDTO.AcessibilidadeRequestDTO acessibilidadeRequestDTO) {
        TipoAcessibilidade newComida = new TipoAcessibilidade(acessibilidadeRequestDTO.getDescription());
        tipoAcessibilidadeRepository.save(newComida);
        return newComida;
    }
}