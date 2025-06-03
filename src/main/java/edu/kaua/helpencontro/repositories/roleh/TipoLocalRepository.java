package edu.kaua.helpencontro.repositories.roleh;

import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.TipoLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLocalRepository extends JpaRepository<TipoLocal, Long> {
}
