package com.inn.travel.com.inn.travel.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import java.io.Serializable;

@NamedQuery(name = "User.findEmailById", query = "select u from User u where u.emailId=:emailId")
@Entity
@Table(name = "user_table") // match actual table name
@Data
@DynamicUpdate
@DynamicInsert
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "password")
    private String password;

    @Column(name = "contact")
    private String contact; // can also be Long if it's a number

    @Column(name = "status")
    private String status; // or Integer depending on use-case
}
