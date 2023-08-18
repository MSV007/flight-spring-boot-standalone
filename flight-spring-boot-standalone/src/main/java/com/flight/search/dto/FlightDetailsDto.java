package com.flight.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/** The type Flight details dto.
 * @author Manish Kumar
 */
@Data
@AllArgsConstructor
public class FlightDetailsDto {
  private String flightNumber;
  private String origin;
  private String destination;
  private String departureTime;
  private String arrivalTime;
  private String duration;
  private int price;
  private String currency;
}
