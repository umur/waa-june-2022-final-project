package com.example.almuni.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.generic.Tag;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue
    private String description;
    private String benefits;
    private List<String> files;
    private List<Tag> tags;



}
