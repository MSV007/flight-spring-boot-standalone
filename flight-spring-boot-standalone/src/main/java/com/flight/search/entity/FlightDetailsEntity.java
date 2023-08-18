package com.flight.search.entity;

import jakarta.persistence.*;
import lombok.Getter;

/** The type Flight details entity.
 * @author Manish Kumar
 */
@Entity
@Table(name = "FLIGHT_DETAILS")
@Getter
public class FlightDetailsEntity {

  @Id
  @Column(name = "flight_number")
  private String flightNumber;

  @Column(name = "origin")
  private String origin;

  @Column(name = "destination")
  private String destination;

  @Column(name = "departure_time")
  private String departureTime;

  @Column(name = "arrival_time")
  private String arrivalTime;

  @Column(name = "price")
  private int price;

  @Column(name = "currency")
  private String currency;
}
