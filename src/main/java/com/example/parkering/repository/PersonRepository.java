package com.example.parkering.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.example.parkering.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    
}