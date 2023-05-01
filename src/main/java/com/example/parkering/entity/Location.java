package com.example.parkering.entity;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;  
  private Point<G2D> cordinate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Point<G2D> getCordinate() {
    return cordinate;
  }

  public void setCordinate(Point<G2D> cordinate) {
    this.cordinate = cordinate;
  }
}
