package org.example.rhytspringboot.services;

import lombok.AllArgsConstructor;
import org.example.rhytspringboot.dtos.CreateVehicleInput;
import org.example.rhytspringboot.dtos.UpdateVehicleInput;
import org.example.rhytspringboot.dtos.VehicleDetails;
import org.example.rhytspringboot.entities.VehicleEntity;
import org.example.rhytspringboot.pagination.Page;
import org.example.rhytspringboot.repositories.ModelRepository;
import org.example.rhytspringboot.repositories.VehicleRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class VehicleService {
  private final VehicleRepository vehicleRepository;
  private final ModelRepository modelRepository;

  public Page<VehicleDetails> index(Pageable pageable) {
    return Page.from(this.vehicleRepository.findAll(pageable).map(VehicleDetails::from));
  }

  public VehicleDetails show(final String id) {
    return this.vehicleRepository.findById(id)
        .map(VehicleDetails::from)
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Vehicle not found"));
  }

  public VehicleDetails create(final CreateVehicleInput input) {
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

    var saved = this.vehicleRepository.save(vehicle);

    return VehicleDetails.from(saved);
  }

  public VehicleDetails update(final String id, final UpdateVehicleInput vehicle) {
    var existing = this.vehicleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Vehicle not found"));

    existing.setKilometers(vehicle.kilometers());
    existing.setColor(vehicle.color());
    existing.setDescription(vehicle.description());
    existing.setYear(vehicle.year());

    var existingModel = Optional.of(existing.getModel()).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Model not found"));
    existing.setModel(existingModel);

    var saved = this.vehicleRepository.save(existing);

    return VehicleDetails.from(saved);
  }

  public void destroy(final String id) {
    if (this.vehicleRepository.existsById(id)) {
      this.vehicleRepository.deleteById(id);
    }
  }
}
