package com.flight.search.service;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.entity.FlightDetailsEntity;
import com.flight.search.enums.OrderBy;
import com.flight.search.enums.SortBy;
import com.flight.search.exception.FlightNotFoundException;
import com.flight.search.exception.SQLException;
import com.flight.search.exception.GenericException;
import com.flight.search.mapper.FlightEntityToDtoMapper;
import com.flight.search.repo.FlightRepository;
import org.hibernate.JDBCException;
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

  private final FlightRepository flightRepository;

  /**
   * Instantiates a new Flight service.
   *
   * @param flightRepository the flight repository
   */
  public FlightServiceImpl(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public List<FlightDetailsDto> searchFlights(
      String origin, String destination, SortBy sortBy, OrderBy orderBy) {
    List<FlightDetailsEntity> flightEntityList = getFlightDetailsEntities(origin, destination);
    return getDetailsDto(sortBy, orderBy, flightEntityList);
  }

  private List<FlightDetailsEntity> getFlightDetailsEntities(String origin, String destination) {
    List<FlightDetailsEntity> flightEntityList;
    try {
      flightEntityList = flightRepository.findByOriginAndDestination(origin, destination);
      if (flightEntityList.isEmpty()) {
        throw new FlightNotFoundException(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
      }
    } catch (JDBCException e) {
      throw new SQLException(SQL_EXCEPTION_MESSAGE, e);
    }
    return flightEntityList;
  }

  private List<FlightDetailsDto> getDetailsDto(
      SortBy sortBy, OrderBy orderBy, List<FlightDetailsEntity> flightEntityList) {
    try {
      List<FlightDetailsDto> flightDtoList = FlightEntityToDtoMapper.mapToDTOs(flightEntityList);
      if (sortBy != null) {
        return getFlightDetailsDto(sortBy, orderBy, flightDtoList);
      } else {
        return flightDtoList;
      }
    } catch (Exception e) {
      throw new GenericException(GENERIC_EXCEPTION_MESSAGE, e);
    }
  }

  private List<FlightDetailsDto> getFlightDetailsDto(
      SortBy sortBy, OrderBy orderBy, List<FlightDetailsDto> flightDtoList) {
    try {
      if (sortBy.equals(SortBy.PRICE)) {
        flightDtoList.sort(Comparator.comparing(FlightDetailsDto::getPrice));
        priceOrderByDesc(orderBy, flightDtoList);
      } else if (sortBy.equals(SortBy.DURATION)) {
        flightDtoList.sort(Comparator.comparing(FlightDetailsDto::getDuration));
        durationOrderByDesc(orderBy, flightDtoList);
      }
    } catch (Exception e) {
      throw new GenericException(GENERIC_EXCEPTION_MESSAGE, e);
    }
    return flightDtoList;
  }

  private void durationOrderByDesc(OrderBy orderBy, List<FlightDetailsDto> flightDtoList) {
    if (OrderBy.DESC.equals(orderBy)) {
      flightDtoList.sort(Comparator.comparing(FlightDetailsDto::getDuration).reversed());
    }
  }

  private void priceOrderByDesc(OrderBy orderBy, List<FlightDetailsDto> flightDtoList) {
    if (OrderBy.DESC.equals(orderBy)) {
      flightDtoList.sort(Comparator.comparing(FlightDetailsDto::getPrice).reversed());
    }
  }
}
