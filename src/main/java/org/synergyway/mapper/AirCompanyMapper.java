package org.synergyway.mapper;

import org.mapstruct.Mapper;
import org.synergyway.config.MapperConfig;
import org.synergyway.dto.AirCompanyDto;
import org.synergyway.model.AirCompany;

@Mapper(config = MapperConfig.class)
public interface AirCompanyMapper {
    AirCompanyDto airCompanyToDto(AirCompany airCompany);
}
