package com.example.parkering.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkering.entity.Car;
import com.example.parkering.entity.Person;
import com.example.parkering.repository.CarRepository;
import com.example.parkering.repository.PersonRepository;
import com.example.parkering.service.CarService;

@RestController
public class CarController {
    CarRepository carRepository;
    PersonRepository personRepository;

    public CarController(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    @PostMapping("/car")
    public ResponseEntity<Car> addCar(@RequestBody Car NewCar) {
        if (CarService.CRegNumber(NewCar.getregNumber())) {
            return new ResponseEntity<>(carRepository.save(NewCar), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/car/{carId}/{personId}")
    public String conectPersonToCar(@PathVariable Long carId, @PathVariable Long personId) {
        Person person = personRepository.findById(personId).get();
        Car car = carRepository.findById(carId).get();
        car.setPerson(person);
        carRepository.save(car);
        return "Add person to car";
    }

    @GetMapping("/car/{carId}")
    public Optional<Car> getOneCar(@PathVariable Long carId) {
        return carRepository.findById(carId);
    }

    @GetMapping("/cars")
    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

}
