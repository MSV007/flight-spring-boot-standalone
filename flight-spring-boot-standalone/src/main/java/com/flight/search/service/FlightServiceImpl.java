package com.flight.search.service;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.entity.FlightDetailsEntity;
import com.flight.search.mapper.FlightEntityToDtoMapper;
import com.flight.search.repo.FlightServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Comparator;
import java.util.List;

/** The type Flight service.
 * @author Manish Kumar
 */
@Service
public class FlightServiceImpl implements FlightService {

  @Autowired private FlightServiceRepository flightServiceRepository;

  /**
   * Search flights list.
   *
   * @param origin the origin
   * @param destination the destination
   * @param departureDate the departure date
   * @param sortBy the sort by
   * @return the list
   */
  @Override
  public List<FlightDetailsDto> searchFlights(
      String origin, String destination, String departureDate, String sortBy) {

    List<FlightDetailsEntity> flights =
        flightServiceRepository.findByOriginAndDestination(origin, destination);
    if(flights.isEmpty()){
      throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "Flights are not available for this route");
    }
    List<FlightDetailsDto> flightList = FlightEntityToDtoMapper.mapToDTOs(flights);
    if (sortBy != null) {
      if (sortBy.equals("price")) {
        flightList.sort(Comparator.comparing(FlightDetailsDto::getPrice));
      } else if (sortBy.equals("duration")) {
        flightList.sort(Comparator.comparing(FlightDetailsDto::getDuration));
      }
    }
    return flightList;
  }
}
