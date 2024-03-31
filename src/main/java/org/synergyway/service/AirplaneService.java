package org.synergyway.service;

import org.synergyway.dto.airplane.AirplaneDto;
import org.synergyway.dto.airplane.AssignAirplaneToCompanyDto;
import org.synergyway.dto.airplane.CreateAirplaneRequestDto;

public interface AirplaneService {
    AirplaneDto save(CreateAirplaneRequestDto requestDto);

    AirplaneDto assignAirplaneToCompanyById(AssignAirplaneToCompanyDto companyName, Long id);

    AirplaneDto assignAirplaneToCompanyByAirplaneName(AssignAirplaneToCompanyDto companyName, String airplaneName);
}
