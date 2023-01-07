package com.example.parkering.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;


@Service
public class TimeService {
    public boolean chkTime(LocalDateTime stoptime){
        return stoptime.isAfter(LocalDateTime.now());
    }
}
