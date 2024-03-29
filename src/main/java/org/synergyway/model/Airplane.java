package org.synergyway.model;

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
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String factorySerialNumber;
    @Column(nullable = false)
    @ManyToOne
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
    private LocalDate createdAt;
}
