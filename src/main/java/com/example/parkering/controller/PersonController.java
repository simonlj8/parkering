package com.example.parkering.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkering.entity.Person;
import com.example.parkering.repository.PersonRepository;

@RestController
public class PersonController {
    PersonRepository timeRepository;



@PostMapping("/parking")
public ResponseEntity<Person> timeStart(){
    return timeStart();
}


}