package org.synergyway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "air_company_id", referencedColumnName = "id", nullable = false)
    private AirCompany airCompany;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "airplane_id")
    private Airplane airplane;
    @Column(nullable = false)
    private String departureCountry;
    @Column(nullable = false)
    private String destinationCountry;
    @Column(nullable = false)
    private BigDecimal distance;
    @Column(nullable = false)
    private LocalTime estimatedFlightTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startedAt;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endedAt;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime delayStartedAt;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
