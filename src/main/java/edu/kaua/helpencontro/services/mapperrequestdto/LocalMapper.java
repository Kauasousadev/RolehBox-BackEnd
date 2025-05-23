package edu.kaua.helpencontro.services.mapperrequestdto;

import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoLocal;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LocalMapper implements Function<Long, TipoLocal> {

    @Override
    public TipoLocal apply(Long localId) {
        return new TipoLocal(
                localId
        );
    }
}