package org.synergyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.synergyway.model.AirCompany;
import java.util.Optional;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    Optional<AirCompany> findAirCompanyByName(String name);

    boolean existsAirCompanyByName(String name);
}
