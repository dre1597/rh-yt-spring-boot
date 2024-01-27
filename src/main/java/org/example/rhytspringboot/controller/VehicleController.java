package org.example.rhytspringboot.controller;

import org.example.rhytspringboot.entities.ManufacturerEntity;
import org.example.rhytspringboot.entities.ModelEntity;
import org.example.rhytspringboot.entities.VehicleEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
  @GetMapping
  public List<VehicleEntity> index() {
    return List.of(new VehicleEntity(
        "any_id",
        0,
        "any_color",
        "any_description",
        true,
        2024,
        new ModelEntity(
            "any_id",
            "any_name",
            new ManufacturerEntity("any_id", "any_name")
        )
    ));
  }

  @GetMapping("/{id}")
  public VehicleEntity show(@PathVariable("id") String id) {
    return new VehicleEntity(
        "any_id",
        0,
        "any_color",
        "any_description",
        true,
        2024,
        new ModelEntity(
            "any_id",
            "any_name",
            new ManufacturerEntity("any_id", "any_name")
        )
    );
  }

  @PostMapping
  public VehicleEntity create(@RequestBody VehicleEntity vehicle) {
    return null;
  }

  @PutMapping("/{id}")
  public VehicleEntity update(@PathVariable("id") String id, @RequestBody VehicleEntity vehicle) {
    return null;
  }

  @DeleteMapping("/{id}")
  public VehicleEntity destroy(@PathVariable("id") String id) {
    return null;
  }
}
