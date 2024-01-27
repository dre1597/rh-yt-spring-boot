package org.example.rhytspringboot.controllers;

import lombok.AllArgsConstructor;
import org.example.rhytspringboot.dtos.CreateVehicleInput;
import org.example.rhytspringboot.entities.VehicleEntity;
import org.example.rhytspringboot.services.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
  private VehicleService service;

  @GetMapping
  public List<VehicleEntity> index() {
    return this.service.index();
  }

  @GetMapping("/{id}")
  public VehicleEntity show(@PathVariable("id") final String id) {
    return this.service.show(id);
  }

  @PostMapping
  public VehicleEntity create(@RequestBody final CreateVehicleInput input) {
    return this.service.create(input);
  }

  @PutMapping("/{id}")
  public VehicleEntity update(@PathVariable("id") final String id, @RequestBody final VehicleEntity vehicle) {
    return this.service.update(id, vehicle);
  }

  @DeleteMapping("/{id}")
  public void destroy(@PathVariable("id") final String id) {
    this.service.destroy(id);
  }
}