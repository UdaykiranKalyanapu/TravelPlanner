package com.inn.travel.com.inn.travel.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "accommodation_table")
@Data
@DynamicUpdate
@DynamicInsert
public class Accommodation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "address")
    private String address;

    @Column(name = "pricePerNight")
    private Double pricePerNight;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "availableRooms")
    private Integer availableRooms;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
}