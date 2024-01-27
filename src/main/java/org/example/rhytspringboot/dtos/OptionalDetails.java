package org.example.rhytspringboot.dtos;

import org.example.rhytspringboot.entities.OptionalEntity;

public record OptionalDetails(
    String id,
    String name
) {
  public static OptionalDetails from(OptionalEntity entity) {
    return new OptionalDetails(
        entity.getId(),
        entity.getName()
    );
  }
}
