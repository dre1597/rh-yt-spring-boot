package org.example.rhytspringboot.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record CreateVehicleInput(
    @Min(value = 0)
    int kilometers,
    @NotEmpty
    String color,
    @NotEmpty
    String description,
    @Min(value = 2000)
    int year,
    @NotEmpty
    String modelId
) {
}
