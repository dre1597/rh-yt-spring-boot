package org.example.rhytspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModelEntity {
  private String id;

  private String name;

  private ManufacturerEntity manufacturer;
}
