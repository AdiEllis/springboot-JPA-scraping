package com.example.springbootJPAscraping.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterestRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private String currentRate;
    private String nextMeeting;

    public InterestRate(Integer id, String country, String currentRate, String nextMeeting) {
        this.id = id;
        this.country = country;
        this.currentRate = currentRate;
        this.nextMeeting = nextMeeting;
    }

    public InterestRate(String country, String currentRate, String nextMeeting) {
        this.country = country;
        this.currentRate = currentRate;
        this.nextMeeting = nextMeeting;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(String currentRate) {
        this.currentRate = currentRate;
    }

    public String getNextMeeting() {
        return nextMeeting;
    }

    public void setNextMeeting(String nextMeeting) {
        this.nextMeeting = nextMeeting;
    }

    @Override
    public String toString() {
        return "InterestRate{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", currentRate='" + currentRate + '\'' +
                ", nextMeeting='" + nextMeeting + '\'' +
                '}';
    }
}
