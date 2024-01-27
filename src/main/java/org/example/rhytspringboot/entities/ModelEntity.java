package org.example.rhytspringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "model")
@Table(name = "models")
public class ModelEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column
  private String name;

  @JoinColumn(name = "manufacturer_id")
  @ManyToOne
  private ManufacturerEntity manufacturer;
}
