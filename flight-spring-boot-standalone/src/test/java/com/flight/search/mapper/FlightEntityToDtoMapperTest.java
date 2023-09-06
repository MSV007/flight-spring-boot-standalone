package com.flight.search.mapper;

import com.flight.search.dto.FlightDetailsDto;
import com.flight.search.entity.FlightDetailsEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.flight.search.util.DateUtil.getDuration;

/**
 * The type Flight entity to dto mapper test.
 * @author Manish Kumar
 */
@SpringBootTest
public class FlightEntityToDtoMapperTest {

  /** Test map to dt os. */
  @Test
  public void testMapToDTOs() {
        // Create a list of FlightDetailsEntity objects
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

        // Create a list of FlightDetailsDto objects
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
        // Call the mapToDTOs() method
        List<FlightDetailsDto> actualFlightsDtos = FlightEntityToDtoMapper.mapToDTOs(flights);
        // Assert that the actual flightsDtos are the same as the expected flightsDtos
        Assertions.assertEquals(expectedFlights, actualFlightsDtos);
    }

}