package org.example.rhytspringboot.dtos;

import org.example.rhytspringboot.entities.ManufacturerEntity;

public record ManufactureDetails(
    String id,
    String name
) {
  public static ManufactureDetails from(ManufacturerEntity entity) {
    return new ManufactureDetails(
        entity.getId(),
        entity.getName()
    );
  }
}
