package edu.kaua.helpencontro.repositories;

import edu.kaua.helpencontro.models.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<Date, Integer> {
}
