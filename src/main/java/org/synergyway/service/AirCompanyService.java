package org.synergyway.service;

import org.springframework.data.domain.Pageable;
import org.synergyway.dto.air_company.AirCompanyDto;
import org.synergyway.dto.air_company.CreateAirCompanyRequestDto;

import java.util.List;

public interface AirCompanyService {
    AirCompanyDto save(CreateAirCompanyRequestDto requestDto);

    List<AirCompanyDto> getAll(Pageable pageable);

    AirCompanyDto findByName(String name);

    AirCompanyDto findById(Long id);

    void deletedById(Long id);

    AirCompanyDto updateById(CreateAirCompanyRequestDto requestDto, Long id);
}
