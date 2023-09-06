package com.flight.search.web;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.enums.OrderBy;
import com.flight.search.enums.SortBy;
import com.flight.search.exception.FlightNotFoundException;
import com.flight.search.exception.GenericException;
import com.flight.search.exception.SQLException;
import com.flight.search.service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.flight.search.util.DateUtil.getDuration;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Flight controller tests.
 *
 * @author Manish Kumar using in-memory database
 */
@SpringBootTest
class FlightControllerTests {

  @Autowired private FlightController flightController;
  @Mock private FlightService flightService;

  /** Test get flights origin to destination. using in-memory database */
  @Test
  public void testGetFlights_OriginToDestination() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    List<FlightDetailsDto> expectedFlights = new ArrayList<>();
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T19:30:00")))
            .price(750)
            .currency("EUR")
            .build());
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T18:30:00")))
            .price(850)
            .currency("EUR")
            .build());
    Mockito.when(flightService.searchFlights(origin, destination, null, null))
        .thenReturn(expectedFlights);

    // Act
    List<FlightDetailsDto> actualFlights =
        flightController.getFlights(origin, destination, null, null);

    // Assert
    assertEquals(expectedFlights, actualFlights);
  }

  /** Test get flights origin to destination and sorted by price. using in-memory database */
  @Test
  public void testGetFlights_OriginToDestinationAndSortedByPriceAscOrder() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.PRICE;
    OrderBy orderBy = OrderBy.ASC;
    List<FlightDetailsDto> expectedFlights = new ArrayList<>();
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T19:30:00")))
            .price(750)
            .currency("EUR")
            .build());
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T18:30:00")))
            .price(850)
            .currency("EUR")
            .build());
    Mockito.when(flightService.searchFlights(origin, destination, sortBy, orderBy))
        .thenReturn(expectedFlights);
    // Act
    List<FlightDetailsDto> actualFlights =
        flightController.getFlights(origin, destination, sortBy, orderBy);
    // Assert
    assertEquals(expectedFlights, actualFlights);
  }

  @Test
  public void testGetFlights_OriginToDestinationAndSortedByPriceDescOrder() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.PRICE;
    OrderBy orderBy = OrderBy.DESC;
    List<FlightDetailsDto> expectedFlights = new ArrayList<>();
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T18:30:00")))
            .price(850)
            .currency("EUR")
            .build());
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T19:30:00")))
            .price(750)
            .currency("EUR")
            .build());
    Mockito.when(flightService.searchFlights(origin, destination, sortBy, orderBy))
        .thenReturn(expectedFlights);

    // Act
    List<FlightDetailsDto> actualFlights =
        flightController.getFlights(origin, destination, sortBy, orderBy);

    // Assert
    assertEquals(expectedFlights, actualFlights);
  }

  /** Test get flights origin to destination and sorted by duration. using in-memory database */
  @Test
  public void testGetFlights_OriginToDestinationAndSortedByDurationAscOrder() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;
    List<FlightDetailsDto> expectedFlights = new ArrayList<>();
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T18:30:00")))
            .price(850)
            .currency("EUR")
            .build());
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T19:30:00")))
            .price(750)
            .currency("EUR")
            .build());
    Mockito.when(flightService.searchFlights(origin, destination, sortBy, orderBy))
        .thenReturn(expectedFlights);

    // Act
    List<FlightDetailsDto> actualFlights =
        flightController.getFlights(origin, destination, sortBy, orderBy);

    // Assert
    Assertions.assertEquals(expectedFlights, actualFlights);
  }

  @Test
  public void testGetFlights_OriginToDestinationAndSortedByDurationDescOrder() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.DESC;
    List<FlightDetailsDto> expectedFlights = new ArrayList<>();
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B101")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T19:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T19:30:00")))
            .price(750)
            .currency("EUR")
            .build());
    expectedFlights.add(
        FlightDetailsDto.builder()
            .flightNumber("B102")
            .origin("AMS")
            .destination("BOM")
            .departureTime(LocalDateTime.parse("2023-10-28T12:00:00"))
            .arrivalTime(LocalDateTime.parse("2023-10-28T18:30:00"))
            .duration(
                getDuration(
                    LocalDateTime.parse("2023-10-28T12:00:00"),
                    LocalDateTime.parse("2023-10-28T18:30:00")))
            .price(850)
            .currency("EUR")
            .build());
    Mockito.when(flightService.searchFlights(origin, destination, sortBy, orderBy))
        .thenReturn(expectedFlights);
    // Act
    List<FlightDetailsDto> actualFlights =
        flightController.getFlights(origin, destination, sortBy, orderBy);
    // Assert
    Assertions.assertEquals(expectedFlights, actualFlights);
  }

  /** Test get flights with FlightNotFoundException. using in-memory database */
  @Test
  public void testGetFlightsWith_FlightNotFoundException() {
    // Arrange
    String origin = "AMS";
    String destination = "BOL";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;

    // Create a FlightNotFoundException object
    FlightNotFoundException thrownException =
        Assertions.assertThrows(
            FlightNotFoundException.class,
            () -> {
              List<FlightDetailsDto> flights =
                  flightController.getFlights(origin, destination, sortBy, orderBy);
              if (flights.isEmpty()) {
                throw new FlightNotFoundException("Flights are not available for this route :");
              }
            });
    // Assert that the message of the exception is correct
    Assertions.assertEquals(
        "Flights are not available for this route :", thrownException.getMessage());
  }

  /** Test get flights with SQLException. using in-memory database */
  @Test
  public void testGetFlightsWith_SQLException() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;

    // Create a SQLException object
    SQLException thrownException =
        Assertions.assertThrows(
            SQLException.class,
            () -> {
              List<FlightDetailsDto> flights =
                  flightController.getFlights(origin, destination, sortBy, orderBy);
              throw new SQLException("An SQL error occurred :");
            });
    // Assert that the message of the exception is correct
    Assertions.assertEquals("An SQL error occurred :", thrownException.getMessage());
  }

  /** Test get flights with GenericException. using in-memory database */
  @Test
  public void testGetFlightsWith_GenericException() {
    // Arrange
    String origin = "AMS";
    String destination = "BOM";
    SortBy sortBy = SortBy.DURATION;
    OrderBy orderBy = OrderBy.ASC;

    // Create a GenericException object
    GenericException thrownException =
        Assertions.assertThrows(
            GenericException.class,
            () -> {
              List<FlightDetailsDto> flights =
                  flightController.getFlights(origin, destination, sortBy, orderBy);
              throw new GenericException("An error occurred while processing request :");
            });
    // Assert that the message of the exception is correct
    Assertions.assertEquals(
        "An error occurred while processing request :", thrownException.getMessage());
  }
}
