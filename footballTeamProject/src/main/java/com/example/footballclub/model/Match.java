package com.example.footballclub.model;

// Match.java

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String location;
    private String opponent;

    public Match() {
    }

    public Match(LocalDate date, String location, String opponent) {
        this.date = date;
        this.location = location;
        this.opponent = opponent;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
}

