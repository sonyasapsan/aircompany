package org.synergyway.dto.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.synergyway.model.FlightStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public final class FindFlightByStatusRequestDto {
    @NotBlank
    private final String name;
    @NotNull
    private final FlightStatus status;
}
