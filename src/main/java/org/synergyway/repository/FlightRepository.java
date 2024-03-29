package org.synergyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.synergyway.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
