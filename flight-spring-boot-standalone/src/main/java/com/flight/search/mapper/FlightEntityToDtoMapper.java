package com.flight.search.mapper;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.entity.FlightDetailsEntity;
import com.flight.search.util.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Flight mapper.
 *
 * @author Manish Kumar
 */
public class FlightEntityToDtoMapper {

  /**
   * Map to entity list to a DTO list.
   *
   * @param flights the flights
   * @return the list
   */
  public static List<FlightDetailsDto> mapToDTOs(List<FlightDetailsEntity> flights) {
    return flights.stream()
        .map(
            flight ->
                new FlightDetailsDto(
                    flight.getFlightNumber(),
                    flight.getOrigin(),
                    flight.getDestination(),
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    DateUtil.getDuration(flight.getDepartureTime(), flight.getArrivalTime()),
                    flight.getPrice(),
                    flight.getCurrency()))
        .collect(Collectors.toList());
  }
}
