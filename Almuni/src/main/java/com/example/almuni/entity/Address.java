package com.example.almuni.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="address")
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
