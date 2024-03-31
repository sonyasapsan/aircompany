package org.synergyway.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.synergyway.dto.flight.CreateFlightRequestDto;
import org.synergyway.dto.flight.FlightDto;
import org.synergyway.service.FlightService;

import javax.validation.Valid;

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
}
