package org.synergyway.dto.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@RequiredArgsConstructor
@Getter
public final class CreateFlightRequestDto {
    @NotBlank
    private final String airCompanyName;
    @NotBlank
    private final String airplaneName;
    @NotBlank
    private final String departureCountry;
    @NotBlank
    private final String destinationCountry;
    @Positive
    private final BigDecimal distance;
    @NotNull
    private final LocalTime estimatedFlightTime;
    @NotNull
    private final LocalDate createdAt;
}
