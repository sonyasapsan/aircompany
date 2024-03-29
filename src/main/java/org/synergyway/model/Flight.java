package org.synergyway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Flight {
    @Id
    private Long id;
    @Column(nullable = false)
    private FlightStatus flightStatus;
    @Column(nullable = false)
    private Long airCompanyId;
    @Column(nullable = false)
    private Long airplaneId;
    @Column(nullable = false)
    private String departureCountry;
    @Column(nullable = false)
    private String destinationCountry;
    @Column(nullable = false)
    private BigDecimal distance;
    @Column(nullable = false)
    private LocalTime estimatedFlightTime;
    @Column(nullable = false)
    private LocalTime startedAt;
    @Column(nullable = false)
    private LocalTime endedAt;
    @Column(nullable = false)
    private LocalTime delayStartedAt;
    @Column(nullable = false)
    private LocalDate createdAt;
}

/*
ID, flight status, Air company id, airplane id, departure country, destination country,
distance, estimated flight time, started at, ended at, delay started at, created at
 */