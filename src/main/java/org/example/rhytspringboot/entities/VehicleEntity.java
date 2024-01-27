package org.example.rhytspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "vehicle")
@Table(name = "vehicles")
public class VehicleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column
  private int kilometers;

  @Column
  private String color;

  @Column
  private String description;

  @Column
  private boolean isAvailable;

  @Column
  private int year;

  @JoinColumn(name = "model_id")
  @ManyToOne
  private ModelEntity model;

  @ManyToMany
  @JoinTable(
      name = "vehicle_optional",
      joinColumns = @JoinColumn(name = "vehicle_id"),
      inverseJoinColumns = @JoinColumn(name = "optional_id")
  )
  private List<OptionalEntity> optionals;

  public VehicleEntity(int kilometers, String color, String description, boolean isAvailable, int year, ModelEntity model) {
    this.kilometers = kilometers;
    this.color = color;
    this.description = description;
    this.isAvailable = isAvailable;
    this.year = year;
    this.model = model;
  }
}
