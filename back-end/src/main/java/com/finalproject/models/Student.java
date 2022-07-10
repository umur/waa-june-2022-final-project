package com.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer studentId;
    private Double gpa;
    private String major;

    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @OneToOne
//    @ToString.Exclude
    private Address address;

//new added
    @OneToOne
    @ToString.Exclude
    private JobHistory jobHistory;

    @OneToOne(mappedBy = "student")
    private  JobAdvertisement jobAdvertisement;

    @OneToMany(mappedBy = "student")
    private List<Comments> comments;
}
