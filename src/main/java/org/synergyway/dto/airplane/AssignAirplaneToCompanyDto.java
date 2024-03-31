package org.synergyway.dto.airplane;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
public final class AssignAirplaneToCompanyDto {
    @NotBlank
    private final String nameCompany;

    @JsonCreator
    public AssignAirplaneToCompanyDto(@JsonProperty("nameCompany") String nameCompany) {
        this.nameCompany = nameCompany;
    }
}
