package org.example.rhytspringboot.dtos;

public record CreateVehicleInput(
    int kilometers,
    String color,
    String description,
    int year,
    String modelId
) {
}
