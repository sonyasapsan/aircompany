package org.synergyway.mapper;

import org.mapstruct.Mapper;
import org.synergyway.config.MapperConfig;
import org.synergyway.dto.air_company.AirCompanyDto;
import org.synergyway.dto.air_company.CreateAirCompanyRequestDto;
import org.synergyway.model.AirCompany;

@Mapper(config = MapperConfig.class)
public interface AirCompanyMapper {
    AirCompanyDto airCompanyToDto(AirCompany airCompany);

    AirCompany toAirCompanyModel(CreateAirCompanyRequestDto requestDto);
}
