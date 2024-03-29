package org.synergyway.mapper;

import org.mapstruct.Mapper;
import org.synergyway.config.MapperConfig;
import org.synergyway.dto.AirplaneDto;
import org.synergyway.model.Airplane;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    AirplaneDto airplaneToDto(Airplane airplane);
}
