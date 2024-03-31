package org.synergyway.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.synergyway.dto.airplane.AirplaneDto;
import org.synergyway.dto.airplane.AssignAirplaneToCompanyDto;
import org.synergyway.dto.airplane.CreateAirplaneRequestDto;
import org.synergyway.service.AirplaneService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AirplaneDto create(@RequestBody @Valid CreateAirplaneRequestDto requestDto) {
        return airplaneService.save(requestDto);
    }

    @PatchMapping("/{id}")
    public AirplaneDto assignAirplaneToCompanyById(@Positive @PathVariable Long id,
                                                   @RequestBody @Valid AssignAirplaneToCompanyDto companyName) {
        return airplaneService.assignAirplaneToCompanyById(companyName, id);
    }

    @PatchMapping("/airplane-name/{name}")
    public AirplaneDto assignAirplaneToCompanyByName(@NotBlank @PathVariable String name,
                                                     @RequestBody @Valid AssignAirplaneToCompanyDto companyName) {
        return airplaneService.assignAirplaneToCompanyByAirplaneName(companyName, name);
    }
}
