package org.synergyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.synergyway.model.AirCompany;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
}
