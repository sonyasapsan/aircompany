package org.synergyway.service;

import org.synergyway.dto.flight.CreateFlightRequestDto;
import org.synergyway.dto.flight.FlightDto;

public interface FlightService {
    FlightDto save(CreateFlightRequestDto requestDto);
}
