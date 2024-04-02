package org.synergyway.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.synergyway.dto.air_company.AirCompanyDto;
import org.synergyway.dto.flight.CreateFlightRequestDto;
import org.synergyway.dto.flight.FindFlightByStatusRequestDto;
import org.synergyway.dto.flight.FlightDto;
import org.synergyway.exception.EntityNotFoundException;
import org.synergyway.exception.IncorrectDataException;
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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

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
                .orElseThrow(() -> new EntityNotFoundException("There is no "
                        + "airplane with such name: " + requestDto.getAirplaneName()));
        flight.setAirplane(airplane);
        AirCompany airCompany = airCompanyRepository.findAirCompanyByName(requestDto.getAirCompanyName())
                        .orElseThrow(() -> new EntityNotFoundException("There is no air company with such name: "
                        + requestDto.getAirCompanyName()));
        flight.setAirCompany(airCompany);
        flight.setFlightStatus(FlightStatus.PENDING);
        flight.setCreatedAt(LocalDate.now());
        return mapper.flightToDto(repository.save(flight));
    }

    @Override
    public FlightDto changeStatusToDelayed(Long id) {
        Flight flight = getFlightById(id);
        if (!flight.getFlightStatus().equals(FlightStatus.PENDING)) {
            throw new IncorrectDataException("The status is incorrect! \n\texpected: " + FlightStatus.PENDING
            + "\n\tactual: " + flight.getFlightStatus());
        }
        flight.setFlightStatus(FlightStatus.DELAYED);
        flight.setDelayStartedAt(LocalDateTime.now());
        return mapper.flightToDto(repository.save(flight));
    }

    @Override
    public FlightDto changeStatusToActive(Long id) {
        Flight flight = getFlightById(id);
        if (flight.getFlightStatus().equals(FlightStatus.ACTIVE) ||
        flight.getFlightStatus().equals(FlightStatus.COMPLETED)) {
            throw new IncorrectDataException("The status is incorrect! \n\texpected: " + FlightStatus.PENDING
                    + ", " + FlightStatus.DELAYED +"\n\tactual: " + flight.getFlightStatus());
        }
        flight.setFlightStatus(FlightStatus.ACTIVE);
        flight.setStartedAt(LocalDateTime.now());
        return mapper.flightToDto(repository.save(flight));
    }

    @Override
    public FlightDto changeStatusToCompleted(Long id) {
        Flight flight = getFlightById(id);
        if (!flight.getFlightStatus().equals(FlightStatus.ACTIVE)) {
            throw new IncorrectDataException("The status is incorrect! \n\texpected: " + FlightStatus.ACTIVE
                    + "\n\tactual: " + flight.getFlightStatus());
        }
        flight.setFlightStatus(FlightStatus.COMPLETED);
        flight.setEndedAt(LocalDateTime.now());
        return mapper.flightToDto(repository.save(flight));
    }

    @Override
    public List<FlightDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).stream()
                .map(mapper::flightToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> getAllFlightsActiveMoreThan24Hours() {
        return repository.getAllActiveMoreThan24Hours().stream()
                .map(mapper::flightToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> getFlightsByStatus(FindFlightByStatusRequestDto requestDto) {
        return repository.findAllByStatusAndCompany(requestDto.getStatus(),
                        requestDto.getName()).stream()
                .map(mapper::flightToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> getAllCompletedFlightsWithLongerExecutionTime() {
        return repository.findAllCompletedFlightsWithLongerExecutionTime().stream()
                .map(mapper::flightToDto)
                .collect(Collectors.toList());
    }

    private Flight getFlightById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no flight with such id: " + id));
    }
}
