package org.synergyway.mapper;

import org.mapstruct.Mapper;
import org.synergyway.config.MapperConfig;
import org.synergyway.dto.FlightDto;
import org.synergyway.model.Flight;

@Mapper(config = MapperConfig.class)
public interface FlightMapper {
    FlightDto flightToDto(Flight flight);
}
