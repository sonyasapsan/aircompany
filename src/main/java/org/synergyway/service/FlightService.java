package org.synergyway.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.synergyway.dto.flight.ChangeFlightStatusRequestDto;
import org.synergyway.dto.flight.CreateFlightRequestDto;
import org.synergyway.dto.flight.FindFlightByStatusRequestDto;
import org.synergyway.dto.flight.FlightDto;

import javax.validation.Valid;
import java.util.List;

public interface FlightService {
    FlightDto save(CreateFlightRequestDto requestDto);

    FlightDto changeStatusToDelayed(Long id);

    FlightDto changeStatusToActive(Long id);

    FlightDto changeStatusToCompleted(Long id);

    List<FlightDto> getAll(Pageable pageable);

    List<FlightDto> getAllFlightsActiveMoreThan24Hours();

    List<FlightDto> getFlightsByStatus(FindFlightByStatusRequestDto requestDto);

    List<FlightDto> getAllCompletedFlightsWithLongerExecutionTime();
}
