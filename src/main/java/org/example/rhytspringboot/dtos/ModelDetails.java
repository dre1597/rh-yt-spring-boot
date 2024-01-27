package org.example.rhytspringboot.dtos;

import org.example.rhytspringboot.entities.ModelEntity;

public record ModelDetails(
    String id,
    String name,
    ManufactureDetails manufacturer
) {
  public static ModelDetails from(ModelEntity entity) {
    return new ModelDetails(
        entity.getId(),
        entity.getName(),
        ManufactureDetails.from(entity.getManufacturer())
    );
  }
}
