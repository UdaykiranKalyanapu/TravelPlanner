package com.inn.travel.com.inn.travel.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "attraction_table")
@Data
@DynamicUpdate
@DynamicInsert
public class Attraction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "openingHours")
    private String openingHours;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
}
