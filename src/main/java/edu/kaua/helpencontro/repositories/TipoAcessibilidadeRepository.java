package edu.kaua.helpencontro.repositories;

import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoAcessibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAcessibilidadeRepository extends JpaRepository<TipoAcessibilidade, Long> {
}
