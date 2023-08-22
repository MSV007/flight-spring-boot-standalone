package com.flight.search.enums;

import lombok.val;

/** The enum Sort by. */
public enum SortBy {
  /** Price sort by. */
  PRICE("price"),
  /** Duration sort by. */
  DURATION("duration");

  private final String value;

  SortBy(String value) {
    this.value = value;
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

}
