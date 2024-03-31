package org.synergyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.synergyway.model.Airplane;

import java.util.Optional;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Optional<Airplane> findByName(String name);
}
