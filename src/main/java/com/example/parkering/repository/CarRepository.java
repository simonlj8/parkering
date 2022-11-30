package com.example.parkering.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parkering.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
    
}
