package com.example.parkering.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkering.entity.Car;
import com.example.parkering.entity.Person;
import com.example.parkering.repository.CarRepository;
import com.example.parkering.repository.PersonRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PersonController {
   
    PersonRepository personRepository;
    CarRepository carRepository;

    public PersonController (
        PersonRepository personRepository,
        CarRepository carRepository
    ) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }
    
    @PostMapping("/person")
    public String addPerson(@RequestBody Person person) {     
        personRepository.save(person);
        return "Person saved";
    }

    @GetMapping("/persons")
    public Iterable<Person> getAllPersonNames(){
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public Person addPerson() {
        Person person = new Person();
        person.setName("Simon");

        Car car1 = new Car();
        car1.setregNumber("DKZ850");    
        carRepository.save(car1);

        Car car2 = new Car();
        car2.setregNumber("ABC123");
        carRepository.save(car2);

        person.addCar(car1);
        person.addCar(car2);

        
        return personRepository.save(person);

    }
    
}

