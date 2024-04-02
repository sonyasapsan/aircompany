package org.synergyway.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.synergyway.dto.air_company.AirCompanyDto;
import org.synergyway.dto.air_company.CreateAirCompanyRequestDto;
import org.synergyway.exception.EntityNotFoundException;
import org.synergyway.mapper.AirCompanyMapper;
import org.synergyway.model.AirCompany;
import org.synergyway.repository.AirCompanyRepository;
import org.synergyway.service.AirCompanyService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyRepository repository;
    private final AirCompanyMapper mapper;

    @Override
    public AirCompanyDto save(CreateAirCompanyRequestDto requestDto) {
        AirCompany airCompany = mapper.toAirCompanyModel(requestDto);
        return mapper.airCompanyToDto(repository.save(airCompany));
    }

    @Override
    public List<AirCompanyDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).stream()
                .map(mapper::airCompanyToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirCompanyDto findByName(String name) {
        return mapper.airCompanyToDto(repository.findAirCompanyByName(name)
                .orElseThrow(() -> new EntityNotFoundException("There is no company with such name:" + name)));
    }

    @Override
    public AirCompanyDto findById(Long id) {
        return mapper.airCompanyToDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no company with such id:" + id)));
    }

    @Override
    public void deletedById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public AirCompanyDto updateById(CreateAirCompanyRequestDto requestDto, Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("There is no company with such id:" + id);
        }
        AirCompany airCompany = mapper.toAirCompanyModel(requestDto);
        airCompany.setId(id);
        return mapper.airCompanyToDto(repository.save(airCompany));
    }
}
