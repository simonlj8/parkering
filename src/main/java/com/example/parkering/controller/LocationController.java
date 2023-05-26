package com.example.parkering.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.parkering.entity.Location;
import com.example.parkering.repository.LocationRepository;

@RestController
public class LocationController {
    LocationRepository locationRepository;

    public LocationController (LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @PostMapping("/location")
    public ResponseEntity<Location> insertOne(@RequestBody Location location) {
        
        var newLocation = locationRepository.save(location);
       
       
        URI locations = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(newLocation.getId())
        .toUri();

        return ResponseEntity.created(locations).body(newLocation);
        
    }

    @GetMapping("/locations")
    public List<Location> allLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/location/{id}")
    public Optional<Location> getOneLocation(@PathVariable Long locationId) {
        return locationRepository.findById(locationId);
    }

}
