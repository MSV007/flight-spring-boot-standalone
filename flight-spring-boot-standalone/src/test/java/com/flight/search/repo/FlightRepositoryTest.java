package com.flight.search.repo;

import com.flight.search.entity.FlightDetailsEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Flight repository test.
 * @author Manish Kumar
 * using in-memory database
 */
@SpringBootTest
public class FlightRepositoryTest {

    @Autowired private FlightRepository jpaRepository;

  /** Test find by origin and destination. */
  @Test
  public void testFindByOriginAndDestination() {

        // Create a list of FlightDetailsEntity objects
        List<FlightDetailsEntity> expectedFlights = new ArrayList<>();
        expectedFlights.add(
                FlightDetailsEntity.builder()
                        .flightNumber("B101")
                        .origin("AMS")
                        .destination("BOM")
                        .departureTime(LocalDateTime.parse("2023-08-28T12:00:00"))
                        .arrivalTime(LocalDateTime.parse("2023-08-28T19:30:00"))
                        .price(750)
                        .currency("EUR")
                        .build());

        // Call the findByOriginAndDestination() method
        List<FlightDetailsEntity> actualFlights = jpaRepository.findByOriginAndDestination("AMS", "BOM");

        // Assert that the actual flights are the same as the expected flights
        Assertions.assertEquals(expectedFlights, actualFlights);
    }

}
