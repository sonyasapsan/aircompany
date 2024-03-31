package org.synergyway.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.synergyway.dto.flight.CreateFlightRequestDto;
import org.synergyway.dto.flight.FlightDto;
import org.synergyway.mapper.FlightMapper;
import org.synergyway.model.AirCompany;
import org.synergyway.model.Airplane;
import org.synergyway.model.Flight;
import org.synergyway.model.FlightStatus;
import org.synergyway.repository.AirCompanyRepository;
import org.synergyway.repository.AirplaneRepository;
import org.synergyway.repository.FlightRepository;
import org.synergyway.service.FlightService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightMapper mapper;
    private final FlightRepository repository;
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public FlightDto save(CreateFlightRequestDto requestDto) {
        Flight flight = mapper.flightToModel(requestDto);
        Airplane airplane = airplaneRepository.findByName(requestDto.getAirplaneName())
                .orElseThrow(() -> new RuntimeException("There is no "
                        + "airplane with such name: " + requestDto.getAirplaneName()));
        flight.setAirplane(airplane);
        AirCompany airCompany = airCompanyRepository.findAirCompanyByName(requestDto.getAirCompanyName())
                        .orElseThrow(() -> new RuntimeException("There is no air company with such name: "
                        + requestDto.getAirCompanyName()));
        flight.setAirCompany(airCompany);
        flight.setFlightStatus(FlightStatus.PENDING);
        flight.setCreatedAt(LocalDate.now());
        return mapper.flightToDto(repository.save(flight));
    }
}
