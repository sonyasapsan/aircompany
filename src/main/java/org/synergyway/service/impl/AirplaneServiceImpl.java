package org.synergyway.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.synergyway.dto.airplane.AirplaneDto;
import org.synergyway.dto.airplane.AssignAirplaneToCompanyDto;
import org.synergyway.dto.airplane.CreateAirplaneRequestDto;
import org.synergyway.exception.EntityNotFoundException;
import org.synergyway.exception.IncorrectDataException;
import org.synergyway.mapper.AirplaneMapper;
import org.synergyway.model.AirCompany;
import org.synergyway.model.Airplane;
import org.synergyway.repository.AirCompanyRepository;
import org.synergyway.repository.AirplaneRepository;
import org.synergyway.service.AirplaneService;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneMapper mapper;
    private final AirplaneRepository repository;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public AirplaneDto save(CreateAirplaneRequestDto requestDto) {
        Airplane airplane = mapper.airplaneToModel(requestDto);
        String companyName = requestDto.getAirCompanyName();
        if (companyName != null && airCompanyRepository.existsAirCompanyByName(companyName)) {
            airplane.setAirCompany(airCompanyRepository.findAirCompanyByName(companyName)
                    .orElseThrow(() -> new IncorrectDataException("Can't assign company with such name: " + companyName)));
        }
        return mapper.airplaneToDto(repository.save(airplane));
    }

    @Override
    public AirplaneDto assignAirplaneToCompanyById(AssignAirplaneToCompanyDto companyName, Long id) {
        Airplane airplane = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No airplane with such id:" + id));
        assignAirplaneToCompany(airplane, companyName.getNameCompany());
        return mapper.airplaneToDto(repository.save(airplane));
    }

    @Override
    public AirplaneDto assignAirplaneToCompanyByAirplaneName(AssignAirplaneToCompanyDto companyName, String airplaneName) {
        Airplane airplane = repository.findByName(airplaneName)
                .orElseThrow(() -> new EntityNotFoundException("No airplane with such name:" + airplaneName));
        assignAirplaneToCompany(airplane, companyName.getNameCompany());
        return mapper.airplaneToDto(repository.save(airplane));
    }

    private void assignAirplaneToCompany(Airplane airplane, String companyName) {
        AirCompany company = airCompanyRepository.findAirCompanyByName(companyName)
                .orElseThrow(() -> new EntityNotFoundException("No company with such name:" + companyName));
        airplane.setAirCompany(company);
    }
}
