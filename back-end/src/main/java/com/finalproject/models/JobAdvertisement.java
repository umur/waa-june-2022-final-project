package com.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime posted;
    private double salary;
    private String benefit;
    @Size(max = 1000)
    private String description;
    private String company;
    private String states;
    private String city;


    @ManyToMany
    @JoinTable(name ="jobs_tags",
        joinColumns = @JoinColumn(name = "jobs_id"),
        inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private List<Tags> tags;

    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private Student student;


}
