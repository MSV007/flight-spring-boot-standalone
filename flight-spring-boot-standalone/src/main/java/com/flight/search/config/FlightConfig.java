package com.flight.search.config;

import com.flight.search.service.FlightService;
import com.flight.search.service.FlightServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The type Flight config.
 * @author Manish Kumar
 */
@Configuration
public class FlightConfig {

  /**
   * Flight service flight service.
   *
   * @return the flight service
   */
  @Bean
  public FlightService flightService() {
    return new FlightServiceImpl();
  }
}
