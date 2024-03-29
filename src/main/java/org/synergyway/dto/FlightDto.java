package org.synergyway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.synergyway.model.FlightStatus;
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
}
