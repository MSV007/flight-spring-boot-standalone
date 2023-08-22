package com.flight.search.service;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.entity.FlightDetailsEntity;
import com.flight.search.enums.SortBy;
import com.flight.search.exception.FlightNotFoundException;
import com.flight.search.exception.SQLException;
import com.flight.search.exception.GenericException;
import com.flight.search.mapper.FlightEntityToDtoMapper;
import com.flight.search.repo.FlightRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * The type Flight service.
 *
 * @author Manish Kumar
 */
@Service
public class FlightServiceImpl implements FlightService {

  @Autowired private FlightRepository flightRepository;

  /**
   * Search flights list.
   *
   * @param origin the origin
   * @param destination the destination
   * @param sortBy the sort by
   * @return the list
   */
  @Override
  public List<FlightDetailsDto> searchFlights(String origin, String destination, SortBy sortBy)
      throws Exception {
    List<FlightDetailsEntity> flightEntityList;
    List<FlightDetailsDto> flightDtoList;
    try {
      flightEntityList = flightRepository.findByOriginAndDestination(origin, destination);
    } catch (JDBCException e) {
      throw new SQLException("An SQL error occurred :", e);
    }
    if (flightEntityList.isEmpty()) {
      throw new FlightNotFoundException("Flights are not available for this route :");
    }
    try {
      flightDtoList = FlightEntityToDtoMapper.mapToDTOs(flightEntityList);
      if (sortBy != null) {
        if (sortBy == SortBy.PRICE) {
          flightDtoList.sort(Comparator.comparing(FlightDetailsDto::getPrice));
        } else if (sortBy == SortBy.DURATION) {
          flightDtoList.sort(Comparator.comparing(FlightDetailsDto::getDuration));
        }
      }
    } catch (Exception e) {
      throw new GenericException("An error occurred while processing request :", e);
    }
    return flightDtoList;
  }
}
