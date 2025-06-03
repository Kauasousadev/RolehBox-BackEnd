package edu.kaua.helpencontro.repositories.roleh;

import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoMusica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMusicaRepository extends JpaRepository<TipoMusica, Long> {
}
