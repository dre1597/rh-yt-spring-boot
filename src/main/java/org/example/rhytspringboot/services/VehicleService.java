package org.example.rhytspringboot.services;

import lombok.AllArgsConstructor;
import org.example.rhytspringboot.dtos.CreateVehicleInput;
import org.example.rhytspringboot.entities.VehicleEntity;
import org.example.rhytspringboot.repositories.ModelRepository;
import org.example.rhytspringboot.repositories.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class VehicleService {
  private final VehicleRepository vehicleRepository;
  private final ModelRepository modelRepository;

  public List<VehicleEntity> index() {
    return this.vehicleRepository.findAll();
  }

  public VehicleEntity show(final String id) {
    return this.vehicleRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Vehicle not found"));
  }

  public VehicleEntity create(final CreateVehicleInput input) {
    final var model = this.modelRepository.findById(input.modelId())
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Model not found"));

    final var vehicle = new VehicleEntity(
        input.kilometers(),
        input.color(),
        input.description(),
        true,
        input.year(),
        model
    );

    return this.vehicleRepository.save(vehicle);
  }

  public VehicleEntity update(final String id, final VehicleEntity vehicle) {
    return this.vehicleRepository.save(vehicle);
  }

  public void destroy(final String id) {
    this.vehicleRepository.deleteById(id);
  }
}
