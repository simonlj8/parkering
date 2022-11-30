
package com.example.parkering.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parkering.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    
}