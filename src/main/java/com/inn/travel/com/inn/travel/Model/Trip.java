package com.inn.travel.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "trip")
@Data
@DynamicUpdate
@DynamicInsert
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "trip_id")
    private Integer tripId;

    @Column(name = "user_id")
    private Integer userId; // FK to User table

    @Column(name = "destination")
    private String destination;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "status")
    private String status; // e.g., Planned, Ongoing, Completed
}
