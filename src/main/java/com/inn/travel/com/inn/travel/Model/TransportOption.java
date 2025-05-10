package com.inn.travel.com.inn.travel.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "transport_option_table")
@Data
@DynamicUpdate
@DynamicInsert
public class TransportOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departureTime")
    private String departureTime;

    @Column(name = "arrivalTime")
    private String arrivalTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "operator")
    private String operator;
}
