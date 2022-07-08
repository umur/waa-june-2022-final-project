package com.example.almuni.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Float gpa;
    private Role role;

    @OneToOne(mappedBy = "faculty")
    private Address address;

    @ManyToOne
    private Department major;
    private Boolean active;
    private LocalDate lastLoggedInAt;

}
