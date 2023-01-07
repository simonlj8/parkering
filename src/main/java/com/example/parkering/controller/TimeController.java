package com.example.parkering.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkering.entity.Time;
import com.example.parkering.repository.TimeRepository;

@RestController
public class TimeController {
    TimeRepository timeRepository;



@PostMapping("/parking")
public ResponseEntity<Time> timeStart(){
    return timeStart();
}


}