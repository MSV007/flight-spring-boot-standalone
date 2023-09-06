package com.flight.search.repo;

import com.flight.search.entity.FlightDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Flight service repository.
 *
 * @author Manish Kumar
 */
@Repository
public interface FlightRepository extends JpaRepository<FlightDetailsEntity, String> {
  /**
   * Find by origin and destination list.
   *
   * @param origin the origin
   * @param destination the destination
   * @return the list
   */
  List<FlightDetailsEntity> findByOriginAndDestination(String origin, String destination);
}
