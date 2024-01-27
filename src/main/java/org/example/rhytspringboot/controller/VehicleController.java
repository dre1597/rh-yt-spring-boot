package org.example.rhytspringboot.controller;

import org.example.rhytspringboot.entities.VehicleEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
  @GetMapping
  public List<VehicleEntity> index() {
    return Collections.emptyList();
  }

  @GetMapping("/{id}")
  public VehicleEntity show(@PathVariable("id") String id) {
    return null;
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
