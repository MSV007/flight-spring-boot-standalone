package com.flight.search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/** The type Flight details dto.
 * @author Manish Kumar
 */
@Data
@AllArgsConstructor
@Builder
public class FlightDetailsDto {
  private String flightNumber;
  private String origin;
  private String destination;
  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;
  private String duration;
  private double price;
  private String currency;
}
