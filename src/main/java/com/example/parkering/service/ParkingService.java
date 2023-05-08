package com.example.parkering.service;

import java.time.LocalDateTime;

//import org.springframework.stereotype.Service;


//@Service
public class ParkingService {
    public static boolean CheckTime(LocalDateTime ParkingEnd){
        return ParkingEnd.isAfter(LocalDateTime.now());
    }
}
