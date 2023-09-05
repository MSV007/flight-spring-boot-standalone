package com.flight.search.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

/** The type Flight details entity.
 * @author Manish Kumar
 */
@Entity
@Table(name = "FLIGHT_DETAILS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightDetailsEntity {

  @Id
  @Column(name = "flight_number")
  private String flightNumber;

  @Column(name = "origin")
  private String origin;

  @Column(name = "destination")
  private String destination;

  @Column(name = "departure_time")
  private LocalDateTime departureTime;

  @Column(name = "arrival_time")
  private LocalDateTime arrivalTime;

  @Column(name = "price")
  private double price;

  @Column(name = "currency")
  private String currency;

}
