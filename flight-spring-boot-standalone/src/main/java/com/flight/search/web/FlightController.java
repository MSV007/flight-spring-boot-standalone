package com.flight.search.web;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

/**
 * The type Flight controller.
 * @author Manish Kumar
 */
@RestController
public class FlightController {

  @Autowired(required = true)
  private FlightService flightService;

  /**
   * Search flights list.
   *
   * @param origin the origin
   * @param destination the destination
   * @param departureDate the departure date
   * @param sortBy the sort by
   * @return the list
   * @throws IOException the io exception
   */
@GetMapping("/v1/flights/search")
  public List<FlightDetailsDto> searchFlights(
      @RequestParam String origin,
      @RequestParam String destination,
      @RequestParam(required = false) String departureDate,
      @RequestParam(required = false) String sortBy)
      throws IOException {
    return flightService.searchFlights(origin, destination, departureDate, sortBy);
  }
}
