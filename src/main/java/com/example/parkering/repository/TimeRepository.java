package com.example.parkering.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.parkering.entity.Time;

public interface TimeRepository extends CrudRepository<Time, Long> {
    
}