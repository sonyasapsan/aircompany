package org.synergyway.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.synergyway.dto.air_company.AirCompanyDto;
import org.synergyway.dto.air_company.CreateAirCompanyRequestDto;
import org.synergyway.service.AirCompanyService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/air-companies")
public class AirCompanyController {
    private AirCompanyService companyService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AirCompanyDto create(@RequestBody @Valid CreateAirCompanyRequestDto requestDto) {
        return companyService.save(requestDto);
    }

    @GetMapping
    public List<AirCompanyDto> getAll(@PageableDefault Pageable pageable) {
        return companyService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public AirCompanyDto findById(@PathVariable @Positive Long id) {
        return companyService.findById(id);
    }

    @GetMapping("/name/{name}")
    public AirCompanyDto findByName(@PathVariable String name) {
        return companyService.findByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive Long id){
        companyService.deletedById(id);
    }

    @PutMapping("/{id}")
    public AirCompanyDto update(@RequestBody @Valid CreateAirCompanyRequestDto requestDto,
                                @PathVariable @Positive Long id) {
        return companyService.updateById(requestDto, id);
    }
}
