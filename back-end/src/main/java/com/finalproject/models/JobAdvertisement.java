package com.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

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
   @Column(insertable = false)

   private boolean mark_delete;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name ="jobs_tags",
        joinColumns = @JoinColumn(name = "jobs_id"),
        inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private List<Tags> tags;

    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private Student student;

    @ElementCollection // 1
    @CollectionTable(name = "photos", joinColumns = @JoinColumn(name = "photoId")) // 2
    @Column(name = "photo") // 3
    private List<String> photos;


}
