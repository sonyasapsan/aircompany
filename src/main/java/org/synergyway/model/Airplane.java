package org.synergyway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(unique = true, nullable = false)
    private String factorySerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "air_company_id", nullable = true)
    private AirCompany airCompany;
    @Column(nullable = false)
    private Integer numberOfFlights;
    @Column(nullable = false)
    private Double flightDistance;
    @Column(nullable = false)
    private Double fuelCapacity;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
