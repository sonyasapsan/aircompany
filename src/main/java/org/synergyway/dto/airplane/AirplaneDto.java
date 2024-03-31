package org.synergyway.dto.airplane;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.synergyway.dto.air_company.AirCompanyDto;

@AllArgsConstructor
@Getter
public final class AirplaneDto {
    private final String name;
    private final AirCompanyDto airCompany;
    private final String type;
}
