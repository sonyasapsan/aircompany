package org.synergyway.mapper;

import org.mapstruct.Mapper;
import org.synergyway.config.MapperConfig;
import org.synergyway.dto.airplane.AirplaneDto;
import org.synergyway.dto.airplane.CreateAirplaneRequestDto;
import org.synergyway.model.Airplane;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    AirplaneDto airplaneToDto(Airplane airplane);

    Airplane airplaneToModel(CreateAirplaneRequestDto requestDto);
}
