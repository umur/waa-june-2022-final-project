package com.finalproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zip;
    private String state;
    private String street;
    private String city;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_user")
    @ToString.Exclude
    @JsonIgnore
    private User user;

}
