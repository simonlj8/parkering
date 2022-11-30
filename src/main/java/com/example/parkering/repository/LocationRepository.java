package com.example.parkering.repository;

//import java.net.URI;

import org.springframework.data.repository.ListCrudRepository;

import com.example.parkering.entity.Location;

public interface LocationRepository extends ListCrudRepository<Location, Long> {

   // static Object save(URI location) {
     //   return null;
    //}
    
}
