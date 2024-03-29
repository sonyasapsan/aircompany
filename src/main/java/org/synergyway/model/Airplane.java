package org.synergyway.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Long idAirCompany;
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
