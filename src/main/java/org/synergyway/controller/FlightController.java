package org.synergyway.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.synergyway.dto.flight.CreateFlightRequestDto;
import org.synergyway.dto.flight.FindFlightByStatusRequestDto;
import org.synergyway.dto.flight.FlightDto;
import org.synergyway.service.FlightService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping("/flights")
@AllArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FlightDto create(@RequestBody @Valid CreateFlightRequestDto requestDto) {
        return flightService.save(requestDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/delay")
    public FlightDto changeFlightStatusToDelayed(@PathVariable @Positive Long id) {
        return flightService.changeStatusToDelayed(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/active")
    public FlightDto changeFlightStatusToActive(@PathVariable @Positive Long id) {
        return flightService.changeStatusToActive(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/complete")
    public FlightDto changeFlightStatusToCompleted(@PathVariable @Positive Long id) {
        return flightService.changeStatusToCompleted(id);
    }

    @GetMapping("/active-more-than-24-hours")
    public List<FlightDto> getAllFlightsActiveMoreThan24Hours() {
        return flightService.getAllFlightsActiveMoreThan24Hours();
    }

    @GetMapping("/by-status")
    public List<FlightDto> getFlightsByStatus(@Valid @RequestBody FindFlightByStatusRequestDto requestDto) {
        return flightService.getFlightsByStatus(requestDto);
    }

    @GetMapping("/completed-with-delay")
    public List<FlightDto> getAllCompletedFlightsWithLongerExecutionTime() {
        return flightService.getAllCompletedFlightsWithLongerExecutionTime();
    }
    @GetMapping
    public List<FlightDto> getAll(@PageableDefault Pageable pageable) {
        return flightService.getAll(pageable);
    }
}
