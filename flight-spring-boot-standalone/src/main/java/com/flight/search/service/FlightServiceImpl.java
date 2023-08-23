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

import static com.flight.search.exception.ErrorConstant.*;

/**
 * The type Flight service.
 *
 * @author Manish Kumar
 */
@Service
public class FlightServiceImpl implements FlightService {

  private FlightRepository flightRepository;

  /**
   * Instantiates a new Flight service.
   *
   * @param flightRepository the flight repository
   */
  public FlightServiceImpl(final FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public List<FlightDetailsDto> searchFlights(String origin, String destination, SortBy sortBy)
      throws Exception {
    List<FlightDetailsEntity> flightEntityList;
    List<FlightDetailsDto> flightDtoList;
    try {
      flightEntityList = flightRepository.findByOriginAndDestination(origin, destination);
    } catch (JDBCException e) {
      throw new SQLException(SQL_EXCEPTION_MESSAGE, e);
    }
    if (flightEntityList.isEmpty()) {
      throw new FlightNotFoundException(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
    }
    try {
      flightDtoList = getFlightDetailsDtos(sortBy, flightEntityList);
    } catch (Exception e) {
      throw new GenericException(GENERIC_EXCEPTION_MESSAGE, e);
    }
    return flightDtoList;
  }

  private List<FlightDetailsDto> getFlightDetailsDtos(
      SortBy sortBy, List<FlightDetailsEntity> flightEntityList) throws GenericException {
    List<FlightDetailsDto> flightDtoList;
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
      throw new GenericException(GENERIC_EXCEPTION_MESSAGE, e);
    }
    return flightDtoList;
  }
}
