package com.flight.search.service;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.entity.FlightDetailsEntity;
import com.flight.search.enums.OrderBy;
import com.flight.search.enums.SortBy;
import com.flight.search.exception.FlightNotFoundException;
import com.flight.search.exception.GenericException;
import com.flight.search.exception.SQLException;
import com.flight.search.mapper.FlightEntityToDtoMapper;
import com.flight.search.repo.FlightRepository;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The type Flight service tests.
 *
 * @author Manish Kumar using in-memory database
 */
@SpringBootTest
public class FlightServiceTests {

  @Mock private FlightEntityToDtoMapper flightEntityToDtoMapper;

  @Autowired private FlightService flightService;


  /**
   * Test search flights.
   *
   * @throws Exception the exception
   */
@Test
  public void testSearchFlights() throws Exception {
    List<FlightDetailsEntity> flights = new ArrayList<>();
    flights.add(
            FlightDetailsEntity.builder()
                    .flightNumber("B101")
                    .origin("AMS")
                    .destination("BOM")
                    .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
                    .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
                    .price(750)
                    .currency("EUR")
                    .build());
    flights.add(
            FlightDetailsEntity.builder()
                    .flightNumber("B102")
                    .origin("AMS")
                    .destination("BOM")
                    .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
                    .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
                    .price(850)
                    .currency("EUR")
                    .build());
    List<FlightDetailsDto> expectedFlights = flightEntityToDtoMapper.mapToDTOs(flights);
    // Call the searchFlights() method
    List<FlightDetailsDto> actualFlights =
            flightService.searchFlights("AMS", "BOM", null, null);

    // Assert that the actual flights are the same as the expected flights
    assertEquals(expectedFlights, actualFlights);
  }

  /**
   * Test search flights sort by price asc order.
   *
   * @throws Exception the exception
   */
@Test
  public void testSearchFlights_SortByPriceAscOrder() throws Exception {
    List<FlightDetailsEntity> flights = new ArrayList<>();
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .price(750)
            .currency("EUR")
            .build());
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .price(850)
            .currency("EUR")
            .build());
    List<FlightDetailsDto> expectedFlights = flightEntityToDtoMapper.mapToDTOs(flights);
    // Call the searchFlights() method
    List<FlightDetailsDto> actualFlights =
        flightService.searchFlights("AMS", "BOM", SortBy.PRICE, OrderBy.ASC);

    // Assert that the actual flights are the same as the expected flights
    assertEquals(expectedFlights, actualFlights);
  }

  /**
   * Test search flights sort by price desc order.
   *
   * @throws Exception the exception
   */
@Test
  public void testSearchFlights_SortByPriceDescOrder() throws Exception {
    List<FlightDetailsEntity> flights = new ArrayList<>();
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .price(850)
            .currency("EUR")
            .build());
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .price(750)
            .currency("EUR")
            .build());
    List<FlightDetailsDto> expectedFlights = flightEntityToDtoMapper.mapToDTOs(flights);
    // Call the searchFlights() method
    List<FlightDetailsDto> actualFlights =
        flightService.searchFlights("AMS", "BOM", SortBy.PRICE, OrderBy.DESC);

    // Assert that the actual flights are the same as the expected flights
    assertEquals(expectedFlights, actualFlights);
  }

  /**
   * Test search flights sort by duration asc order.
   *
   * @throws Exception the exception
   */
@Test
  public void testSearchFlights_SortByDurationAscOrder() throws Exception {
    List<FlightDetailsEntity> flights = new ArrayList<>();
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .price(850)
            .currency("EUR")
            .build());
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .price(750)
            .currency("EUR")
            .build());
    List<FlightDetailsDto> expectedFlights = flightEntityToDtoMapper.mapToDTOs(flights);

    // Call the searchFlights() method
    List<FlightDetailsDto> actualFlights =
        flightService.searchFlights("AMS", "BOM", SortBy.DURATION, OrderBy.ASC);
    // Assert that the actual flights are the same as the expected flights
    assertEquals(expectedFlights, actualFlights);
  }

  /**
   * Test search flights sort by duration desc order.
   *
   * @throws Exception the exception
   */
@Test
  public void testSearchFlights_SortByDurationDescOrder() throws Exception {
    List<FlightDetailsEntity> flights = new ArrayList<>();
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .price(750)
            .currency("EUR")
            .build());
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .price(850)
            .currency("EUR")
            .build());
    List<FlightDetailsDto> expectedFlights = flightEntityToDtoMapper.mapToDTOs(flights);

    // Call the searchFlights() method
    List<FlightDetailsDto> actualFlights =
        flightService.searchFlights("AMS", "BOM", SortBy.DURATION, OrderBy.DESC);
    // Assert that the actual flights are the same as the expected flights
    assertEquals(expectedFlights, actualFlights);
  }

  /**
   * Test search flights flight not found exception.
   */
@Test
  public void testSearchFlights_FlightNotFoundException() {
    // Arrange

    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;
    FlightRepository flightRepository = mock(FlightRepository.class);
    List<FlightDetailsEntity> flightEntityList = new ArrayList<>();

    when(flightRepository.findByOriginAndDestination(anyString(), anyString())).thenReturn(flightEntityList);

    FlightService flightService = new FlightServiceImpl(flightRepository);

    // Act and Assert
    FlightNotFoundException exception = assertThrows(FlightNotFoundException.class, () -> {
      flightService.searchFlights(origin, destination, sortBy, orderBy);
    });

    assertEquals("Flights are not available for this route :", exception.getMessage());
  }

  /**
   * Test search flights sql exception.
   */
@Test
  public void testSearchFlights_SQLException() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;
    FlightRepository flightRepository = mock(FlightRepository.class);

    when(flightRepository.findByOriginAndDestination(anyString(), anyString())).thenThrow(new JDBCException("SQL Exception", null, null));

    FlightService flightService = new FlightServiceImpl(flightRepository);

    // Act and Assert
    SQLException exception = assertThrows(SQLException.class, () -> {
      flightService.searchFlights(origin, destination, sortBy, orderBy);
    });

    assertEquals("An SQL error occurred :", exception.getMessage());
  }

  /**
   * Test search flights generic exception.
   */
@Test
  public void testSearchFlights_GenericException() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;
    FlightRepository flightRepository = mock(FlightRepository.class);

    when(flightRepository.findByOriginAndDestination(anyString(), anyString())).thenThrow(new JDBCException("SQL Exception", null, null));

    FlightService flightService = new FlightServiceImpl(flightRepository);

    // Act and Assert
    SQLException exception = assertThrows(SQLException.class, () -> {
      flightService.searchFlights(origin, destination, sortBy, orderBy);
    });

    assertEquals("An SQL error occurred :", exception.getMessage());
  }

  /**
   * Test search flights generic exception with dates.
   */
@Test
  public void testSearchFlights_GenericExceptionWithDates() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;
    FlightRepository flightRepository = mock(FlightRepository.class);
    List<FlightDetailsEntity> flightEntityList = new ArrayList<>();
    flightEntityList.add(FlightDetailsEntity.builder().flightNumber("AMS").build());
    when(flightRepository.findByOriginAndDestination(anyString(), anyString())).thenReturn(flightEntityList);

    // Mock FlightEntityToDtoMapper to throw an exception
    FlightEntityToDtoMapper mapper = mock(FlightEntityToDtoMapper.class);
    FlightService flightService = new FlightServiceImpl(flightRepository);

    // Act and Assert
    GenericException exception = assertThrows(GenericException.class, () -> {
      flightService.searchFlights(origin, destination, sortBy, orderBy);
    });

    assertEquals("An error occurred while processing request :", exception.getMessage());
  }

}
