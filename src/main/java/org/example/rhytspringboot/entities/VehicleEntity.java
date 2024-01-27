package org.example.rhytspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleEntity {
  private String id;

  private int kilometers;

  private String color;

  private String description;

  private boolean isAvailable;

  private int year;

  private ModelEntity model;
}
