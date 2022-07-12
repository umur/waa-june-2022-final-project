package com.waa.amp.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    private String state;

    private String city;

    private String companyName;

    @OneToOne(fetch = FetchType.EAGER)
    private User postedBy;



}
