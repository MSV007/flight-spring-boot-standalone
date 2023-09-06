package com.flight.search.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Date util.
 *
 * @author Manish Kumar
 */
public class DateUtil {

  /** The constant SPACE_SEPARATOR. */
  public static String SPACE_SEPARATOR = " ";
  /** The constant FORMATTER_PATTERN. */
  public static String FORMATTER_PATTERN = "yyyy-MM-dd HH:mm";
  /** The constant MINUTE. */
  public static String MINUTE = "minutes";

  /**
   * Gets duration.
   *
   * @param departureTime the departure time
   * @param arrivalTime the arrival time
   * @return the duration
   */
  public static String getDuration(LocalDateTime departureTime, LocalDateTime arrivalTime) {
    Duration duration = Duration.between(departureTime, arrivalTime);
    int minutes = ((int) duration.toMinutes());
    return minutes + SPACE_SEPARATOR + MINUTE;
  }
}
