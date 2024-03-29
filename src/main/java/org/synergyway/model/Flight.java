package org.synergyway.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "flights")
public class Flight {
    @Id
    private Long id;
    @Column(nullable = false)
    private FlightStatus flightStatus;
    @Column(nullable = false)
    @ManyToOne
    private AirCompany airCompany;
    @Column(nullable = false)
    @OneToOne
    private AirCompany airplane;
    @Column(nullable = false)
    private String departureCountry;
    @Column(nullable = false)
    private String destinationCountry;
    @Column(nullable = false)
    private BigDecimal distance;
    @Column(nullable = false)
    private LocalTime estimatedFlightTime;
    private LocalTime startedAt;
    private LocalTime endedAt;
    private LocalTime delayStartedAt;
    @Column(nullable = false)
    private LocalDate createdAt;
}

/*
ID, flight status, Air company id, airplane id, departure country, destination country,
distance, estimated flight time, started at, ended at, delay started at, created at
 */