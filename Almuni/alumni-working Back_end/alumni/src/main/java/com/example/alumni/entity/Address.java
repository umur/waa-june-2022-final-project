package com.example.alumni.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    @OneToOne
    private Student student;
    @OneToOne
    private Faculty faculty;
}
