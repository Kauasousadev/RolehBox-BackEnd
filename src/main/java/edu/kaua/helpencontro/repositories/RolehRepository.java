package edu.kaua.helpencontro.repositories;

import edu.kaua.helpencontro.models.Roleh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolehRepository extends JpaRepository<Roleh, Integer> {
}
