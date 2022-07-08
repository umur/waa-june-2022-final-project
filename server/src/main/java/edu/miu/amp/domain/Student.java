package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor@AllArgsConstructor
public class Student extends User {
    @Id
    @GeneratedValue
    private Integer id;

    private Float gpa;
    private String CVFile;

    @ManyToOne/**/
    private Department department;



    @OneToMany
    private List<JobAdvertisement> jobAdvertisementList;

}
