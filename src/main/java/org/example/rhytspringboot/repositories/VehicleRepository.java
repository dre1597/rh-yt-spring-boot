package org.example.rhytspringboot.repositories;

import org.example.rhytspringboot.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {
}
