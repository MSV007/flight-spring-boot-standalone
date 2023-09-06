package com.flight.search.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.flight.search.util.DateUtil.getDuration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DateUtilTest {

    @Test
    public void testGetDuration() {
        // Arrange
        LocalDateTime departureTime = LocalDateTime.of(2023, 9, 1, 10, 0); // Example departure time
        LocalDateTime arrivalTime = LocalDateTime.of(2023, 9, 1, 11, 30); // Example arrival time
        // Act
        String result = getDuration(departureTime, arrivalTime);
        // Assert
        String expected = "90 minutes";
        assertEquals(expected, result);
    }
}
