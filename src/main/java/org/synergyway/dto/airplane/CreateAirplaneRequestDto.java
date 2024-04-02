package org.synergyway.dto.airplane;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public final class CreateAirplaneRequestDto {
    @NotBlank
    private final String name;
    @NotBlank
    private final String factorySerialNumber;
    @NotBlank
    private final String airCompanyName;
    @Positive
    private final int numberOfFlights;
    @Positive
    private final Double flightDistance;
    @Positive
    private final Double fuelCapacity;
    @NotNull
    private final String type;
    @NotNull
    private final LocalDate createdAt;
}
