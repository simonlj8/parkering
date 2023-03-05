package com.example.parkering.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private LocalDateTime timeStart;
    private LocalDateTime timeStop;

   // private Location location;

    public Long getID() {
        return ID;
    }

    public void setID(Long id) {
        ID = id;
    }
    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(LocalDateTime timeStop) {
        this.timeStop = timeStop;
    }

   /*  public Location getLocation() {
        return location;
    }*/

}
