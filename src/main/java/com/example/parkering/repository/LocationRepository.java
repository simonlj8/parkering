package com.example.parkering.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.parkering.entity.Location;

public interface LocationRepository extends ListCrudRepository<Location, Long> {

    
}
