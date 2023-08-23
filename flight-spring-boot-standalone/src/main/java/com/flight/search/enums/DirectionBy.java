package com.flight.search.enums;

/** The enum Sort by. */
public enum DirectionBy {

  /**
   *Asc direction by.
   */
ASC("asc"),
  /** Desc direction by. */
  DESC("desc");

  private final String value;

  DirectionBy(String value) {
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
