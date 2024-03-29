package org.synergyway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class AirplaneDto {
    private final String name;
    private final AirCompanyDto airCompany;
    private final String type;
}
