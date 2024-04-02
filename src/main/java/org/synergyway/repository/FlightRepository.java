package org.synergyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.synergyway.model.Flight;
import org.synergyway.model.FlightStatus;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value = "SELECT * FROM flights"
            + " WHERE flight_status LIKE 'ACTIVE'"
            + " AND started_at < DATE_SUB(NOW(), INTERVAL 1 DAY)", nativeQuery = true)
    List<Flight> getAllActiveMoreThan24Hours();

    @Query("SELECT flight FROM Flight flight"
            + " JOIN flight.airCompany company"
            + " WHERE flight.flightStatus = :status"
            + " AND company.name LIKE :companyName")
    List<Flight> findAllByStatusAndCompany(FlightStatus status, String companyName);

    @Query(value = "SELECT * FROM flights"
            + " WHERE flight_status LIKE 'COMPLETED'"
            + " AND TIMEDIFF(ended_at, started_at) > estimated_flight_time", nativeQuery = true)
    List<Flight> findAllCompletedFlightsWithLongerExecutionTime();
}
