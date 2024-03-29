package com.example.parkering.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.parkering.entity.Car;
import com.example.parkering.entity.Parking;
import com.example.parkering.entity.Location;
import com.example.parkering.entity.Person;
import com.example.parkering.repository.CarRepository;
import com.example.parkering.repository.LocationRepository;
import com.example.parkering.repository.ParkingRepository;
import com.example.parkering.repository.PersonRepository;
import com.example.parkering.service.ParkingService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ParkingController {
   
    ParkingRepository parkingRepository;
    CarRepository carRepository;
    LocationRepository locationRepository;
    PersonRepository personRepository;

    public ParkingController (
        ParkingRepository parkingRepository,
        CarRepository carRepository,
        LocationRepository locationRepository,
        PersonRepository personRepository)
         {
        this.parkingRepository = parkingRepository;
        this.carRepository = carRepository;
        this.locationRepository = locationRepository;
        this.personRepository = personRepository;
    }
    /* 
    //
   /*  @PostMapping("/person")
    public String addPerson(@RequestBody Person person) {     
        personRepository.save(person);
        return "Person saved";
    }

    @PostMapping("/person")
    public ResponseEntity<Parking> addPerson(@RequestBody Parking person) {
        return new ResponseEntity<>(parkingRepository.save(person), HttpStatus.OK);
    }
    //

    //
    /*@GetMapping("/persons")
    public Iterable<Person> getAllPersonNames(){
        return personRepository.findAll();
    }

    @GetMapping("/persons")
    public Iterable<Parking> getAllPersons() {
        return personRepository.findAll();
    }

//
    @PostMapping("/persons")
    public Parking addPerson() {
        Parking person = new Parking();
        person.setName("Simon");

        Car car1 = new Car();
        car1.setregNumber("DKZ800");    
        carRepository.save(car1);

        Car car2 = new Car();
        car2.setregNumber("ABC123");
        carRepository.save(car2);

        person.addCar(car1);
        person.addCar(car2);

        
        return personRepository.save(person);

    }
    
}*/

@PostMapping("/parking/{personId}/{carId}/{locationId}")
public ResponseEntity<Parking> Parking(
        @RequestBody Parking Parking,
        @PathVariable Long personId,
        @PathVariable Long carId,
        @PathVariable Long locationId) {

    Person person = personRepository.findById(personId).get();
    Parking.setPerson(person);
    Car car = carRepository.findById(carId).get();
    Parking.setCar(car);
    Location location = locationRepository.findById(locationId).get();
    Parking.setLocation(location);
    LocalDateTime startTime = LocalDateTime.now();
    Parking.setParkingStart(startTime);
    Parking.setStatus("Active");

    if (ParkingService.CheckTime(Parking.getParkingEnd())) {
            var newParking = parkingRepository.save(Parking);
            return ResponseEntity.ok(newParking);
    }
    return ResponseEntity.badRequest().build();
}

@PatchMapping("/parking/{parkingId}")
public ResponseEntity<Parking> addTime(@RequestBody Parking newEndTime, @PathVariable Long parkingId) {
    if (ParkingService.CheckTime(newEndTime.getParkingEnd())) {
        LocalDateTime NewParkingEnd = newEndTime.getParkingEnd();
        Parking oldParking = parkingRepository.findById(parkingId).get();
        oldParking.setParkingEnd(NewParkingEnd);

        var addTimeParking = parkingRepository.save(oldParking);
        return ResponseEntity.ok(addTimeParking);
    }
    return ResponseEntity.badRequest().build();
}

@PatchMapping("/parking/end/{parkingId}")
public ResponseEntity<Parking> endParking(@PathVariable Long parkingId) {
    Parking endParking = parkingRepository.findById(parkingId).get();
    LocalDateTime EndTime = LocalDateTime.now(); 
    endParking.setParkingEnd(EndTime);
    endParking.setStatus("Ended");

    var endedParking = parkingRepository.save(endParking);
        return ResponseEntity.ok(endedParking);
}

@GetMapping("/parking/{parkingId}")
public Optional<Parking> getOne(@PathVariable Long parkingId) {
    return parkingRepository.findById(parkingId);
}

@GetMapping("/parkings")
public Iterable<Parking> getAllParkings() {
    return parkingRepository.findAll();
}

@GetMapping("/parkings/ended")
public Iterable<Parking> getAllEndedParkings() {
    return parkingRepository.findByStatus("ended");
}

@GetMapping("/parkings/active")
public Iterable<Parking> getAllActiveParkings() {
    return parkingRepository.findByStatus("active");
}

@GetMapping("/parkings/person/{personId}")
public Iterable<Parking> getAllParkingsForPerson(@PathVariable Long personId) {
    return parkingRepository.findByPersonId(personId);
}

@GetMapping("/parkings/car/{carId}")
public Iterable<Parking> getAllParkingsForCar(@PathVariable Long carId) {
    return parkingRepository.findByCarId(carId);
}

}

