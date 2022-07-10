package com.finalproject.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
public class Applied {
    @Id
    @GeneratedValue
    private Long id;
    private String cv;
    private Integer contactNumber;

    public Applied(String cv, Integer contactNumber) {
        this.cv = cv;
        this.contactNumber = contactNumber;
    }

    public Applied() {

    }
}
