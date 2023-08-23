package com.flight.search.web;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.enums.OrderBy;
import com.flight.search.enums.SortBy;
import com.flight.search.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * The type Flight controller.
 * @author Manish Kumar
 */
@RestController
@RequestMapping("/flights")
public class FlightController {

  @Autowired
  private FlightService flightService;


/**
 * Gets flights.
 *
 * @param origin the origin
 * @param destination the destination
 * @param sortBy the sort by
 * @param orderBy the order by
 * @return the flights
 * @throws Exception the exception
 */
@GetMapping("/v1/getFlights")
  public List<FlightDetailsDto> getFlights(
      @RequestParam String origin,
      @RequestParam String destination,
      @RequestParam(required = false) SortBy sortBy,
      @RequestParam(required = false) OrderBy orderBy) throws Exception{
    return flightService.searchFlights(origin, destination, sortBy, orderBy);
  }
}
