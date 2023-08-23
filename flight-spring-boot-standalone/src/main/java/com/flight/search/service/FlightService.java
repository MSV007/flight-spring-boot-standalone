package com.flight.search.service;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.enums.OrderBy;
import com.flight.search.enums.SortBy;

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
 * @param sortBy the sort by
 * @param orderBy the order by
 * @return the list
 * @throws Exception the exception
 */
List<FlightDetailsDto> searchFlights(
      String origin,
      String destination,
      SortBy sortBy,
      OrderBy orderBy) throws Exception;
}
