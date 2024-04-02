package org.synergyway.dto.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.synergyway.model.FlightStatus;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public final class ChangeFlightStatusRequestDto {
    @NotNull
    public final FlightStatus flightStatus;
}
