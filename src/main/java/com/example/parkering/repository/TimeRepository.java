package com.example.parkering.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.example.parkering.entity.Time;

public interface TimeRepository extends ListCrudRepository<Time, Long> {
    
}