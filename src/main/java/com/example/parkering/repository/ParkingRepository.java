
package com.example.parkering.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parkering.entity.Parking;

public interface ParkingRepository extends CrudRepository<Parking, Long> {
    
}