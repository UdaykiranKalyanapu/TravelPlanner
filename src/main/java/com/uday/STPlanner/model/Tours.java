package com.uday.STPlanner.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="toursavailable")

public class Tours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;

    @Column(nullable = false)
    private String countryName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private int numberOfDays;

    @Column(nullable = false)
    private double cost;

    // Constructors
    public Tours() {
    }

    public Tours(String countryName, String description, int numberOfDays, double cost) {
        this.countryName = countryName;
        this.description = description;
        this.numberOfDays = numberOfDays;
        this.cost = cost;
    }

    // Getters and Setters

    public ObjectId  getId() {
        return id;
    }

    public void setId(ObjectId  id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", description='" + description + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", cost=" + cost +
                '}';
    }
}
