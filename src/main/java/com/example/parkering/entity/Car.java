package com.example.parkering.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regNr;

    @ManyToOne
    private Parking person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getregNr() {
        return regNr;
    }

    public void setregNr(String regNr) {
        this.regNr = regNr;
    }


    public Parking getPerson() {
        return person;
    }

    public void setPerson(Parking person) {
        this.person = person;
    }
}
