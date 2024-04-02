package org.synergyway.dto.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.synergyway.dto.air_company.AirCompanyDto;
import org.synergyway.dto.airplane.AirplaneDto;
import org.synergyway.model.FlightStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public final class FlightDto {
    private final FlightStatus flightStatus;
    private final AirCompanyDto airCompany;
    private final AirplaneDto airplane;
    private final String departureCountry;
    private final String destinationCountry;
    private final LocalTime estimatedFlightTime;
    private final LocalDateTime startedAt;
    private final LocalDateTime endedAt;
    private final LocalDateTime delayStartedAt;
}
