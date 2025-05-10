package com.inn.travel.com.inn.travel.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "destination_table")
@Data
@DynamicUpdate
@DynamicInsert
public class Destination implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;
}