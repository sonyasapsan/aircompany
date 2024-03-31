package org.synergyway.dto.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
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
    private final LocalTime estimatedFlightTime;
}
