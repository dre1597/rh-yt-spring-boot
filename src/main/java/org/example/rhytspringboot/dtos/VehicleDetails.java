package org.example.rhytspringboot.dtos;

import org.example.rhytspringboot.entities.VehicleEntity;

import java.util.List;

public record VehicleDetails(
    String id,
    int kilometers,
    String color,
    String description,
    int year,
    ModelDetails model,
    List<OptionalDetails> optionals
) {
  public static VehicleDetails from(VehicleEntity entity) {
    return new VehicleDetails(
        entity.getId(),
        entity.getKilometers(),
        entity.getColor(),
        entity.getDescription(),
        entity.getYear(),
        ModelDetails.from(entity.getModel()),
        entity.getOptionals().stream().map(OptionalDetails::from).toList()
    );
  }
}
