package com.example.parkering.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkering.entity.Car;
import com.example.parkering.repository.CarRepository;

@RestController
public class CarController {
    CarRepository carRepository;

    public CarController (CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        carRepository.save(car);
        return "Car is saved";
    }

    @GetMapping("/car")
    public Iterable<Car> getAllCarNames(){
        return carRepository.findAll();
    }
    
}
