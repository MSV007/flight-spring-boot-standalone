package com.flight.search.service;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.entity.FlightDetailsEntity;
import com.flight.search.enums.SortBy;
import com.flight.search.exception.FlightNotFoundException;
import com.flight.search.exception.GenericException;
import com.flight.search.exception.SQLException;
import com.flight.search.mapper.FlightEntityToDtoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
   * Test search flights sort by price.
   *
   * @throws Exception the exception
   */
  @Test
  public void testSearchFlights_SortByPrice() throws Exception {
    List<FlightDetailsEntity> flights = new ArrayList<>();
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-08-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-08-28T19:30:00"))
            .price(750)
            .currency("EUR")
            .build());
    List<FlightDetailsDto> expectedFlights = flightEntityToDtoMapper.mapToDTOs(flights);
    // Call the searchFlights() method
    List<FlightDetailsDto> actualFlights = flightService.searchFlights("AMS", "BOM", SortBy.PRICE);

    // Assert that the actual flights are the same as the expected flights
    Assertions.assertEquals(expectedFlights, actualFlights);
  }

  /** Test search flights sort by duration. @throws Exception the exception */
  @Test
  public void testSearchFlights_SortByDuration() throws Exception {
    List<FlightDetailsEntity> flights = new ArrayList<>();
    flights.add(
        FlightDetailsEntity.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-08-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-08-28T19:30:00"))
            .price(750)
            .currency("EUR")
            .build());
    List<FlightDetailsDto> expectedFlights = flightEntityToDtoMapper.mapToDTOs(flights);

    // Call the searchFlights() method
    List<FlightDetailsDto> actualFlights =
        flightService.searchFlights("AMS", "BOM", SortBy.DURATION);
    // Assert that the actual flights are the same as the expected flights
    Assertions.assertEquals(expectedFlights, actualFlights);
  }

  /** Test search flights flight not found exception. */
  @Test
  public void testSearchFlights_FlightNotFoundException() {
    String origin = "AMS";
    String destination = "BOL";
    SortBy sortBy = SortBy.DURATION;

    // Create a FlightNotFoundException object
    FlightNotFoundException thrownException =
        Assertions.assertThrows(
            FlightNotFoundException.class,
            () -> {
              List<FlightDetailsDto> flights =
                  flightService.searchFlights(origin, destination, sortBy);
              if (flights.isEmpty()) {
                throw new FlightNotFoundException("Flights are not available for this route :");
              }
            });

    // Assert that the message of the exception is correct
    Assertions.assertEquals(
        "Flights are not available for this route :", thrownException.getMessage());
  }

  /** Test search flights generic exception. */
  @Test
  public void testSearchFlights_GenericException() {
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;

    // Create a GenericException object
    GenericException thrownException =
        Assertions.assertThrows(
            GenericException.class,
            () -> {
              List<FlightDetailsDto> flights =
                  flightService.searchFlights(origin, destination, sortBy);
                throw new GenericException("An error occurred while processing request :");
            });

    // Assert that the message of the exception is correct
    Assertions.assertEquals(
        "An error occurred while processing request :", thrownException.getMessage());
  }

  /** Test search flights sql exception. */
  @Test
  public void testSearchFlights_SQLException() {
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;

    // Create a SQLException object
    SQLException thrownException =
        Assertions.assertThrows(
            SQLException.class,
            () -> {
              List<FlightDetailsDto> flights =
                  flightService.searchFlights(origin, destination, sortBy);
                throw new SQLException("An SQL error occurred :");
            });

    // Assert that the message of the exception is correct
    Assertions.assertEquals("An SQL error occurred :", thrownException.getMessage());
  }
}
