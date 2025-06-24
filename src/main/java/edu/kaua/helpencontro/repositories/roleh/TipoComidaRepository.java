package edu.kaua.helpencontro.repositories.roleh;

import edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica.TipoComida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoComidaRepository extends JpaRepository<TipoComida, Long> {
}
