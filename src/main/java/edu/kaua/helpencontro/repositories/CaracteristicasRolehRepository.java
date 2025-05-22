package edu.kaua.helpencontro.repositories;

import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicasRolehRepository extends JpaRepository<CaracteristicaRole, Integer> {
}
