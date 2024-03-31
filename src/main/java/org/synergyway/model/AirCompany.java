package org.synergyway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "air_companies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, name = "company_type")
    private String companyType;
    @Column(nullable = false, name = "founded_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundedAt;
}
