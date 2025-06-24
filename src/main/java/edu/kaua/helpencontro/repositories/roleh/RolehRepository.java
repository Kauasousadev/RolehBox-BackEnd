package edu.kaua.helpencontro.repositories.roleh;

import edu.kaua.helpencontro.models.roleh.Roleh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolehRepository extends JpaRepository<Roleh, Long> {
}
