package org.synergyway.dto.air_company;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CreateAirCompanyRequestDto {
    @NotBlank
    private final String name;
    @NotBlank
    private final String companyType;
    @NotNull
    private final LocalDate foundedAt;
}
