package com.flight.search.service;

import com.flight.search.dto.FlightDetailsDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * The interface Flight service.
 * @author Manish Kumar
 */
public interface FlightService {

  /**
   * Search flights list.
   *
   * @param origin the origin
   * @param destination the destination
   * @param departureDate the departure date
   * @param sortBy the sort by
   * @return the list
   */
List<FlightDetailsDto> searchFlights(
      @RequestParam String origin,
      @RequestParam String destination,
      @RequestParam(required = false) String departureDate,
      @RequestParam(required = false) String sortBy);
}
