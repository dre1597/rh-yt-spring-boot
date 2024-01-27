package org.example.rhytspringboot.controllers;

import lombok.AllArgsConstructor;
import org.example.rhytspringboot.dtos.CreateVehicleInput;
import org.example.rhytspringboot.dtos.VehicleDetails;
import org.example.rhytspringboot.entities.VehicleEntity;
import org.example.rhytspringboot.pagination.Page;
import org.example.rhytspringboot.services.VehicleService;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
  private VehicleService service;

  @GetMapping
  public Page<VehicleDetails> index(Pageable pageable) {
    return this.service.index(pageable);
  }

  @GetMapping("/{id}")
  public VehicleDetails show(@PathVariable("id") final String id) {
    return this.service.show(id);
  }

  @PostMapping
  public VehicleDetails create(@RequestBody @Validated final CreateVehicleInput input) {
    return this.service.create(input);
  }

  @PutMapping("/{id}")
  public VehicleDetails update(@PathVariable("id") final String id, @RequestBody final VehicleEntity vehicle) {
    return this.service.update(id, vehicle);
  }

  @DeleteMapping("/{id}")
  public void destroy(@PathVariable("id") final String id) {
    this.service.destroy(id);
  }
}
