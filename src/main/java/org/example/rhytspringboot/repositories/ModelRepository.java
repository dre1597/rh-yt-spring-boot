package org.example.rhytspringboot.repositories;

import org.example.rhytspringboot.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, String> {
}
