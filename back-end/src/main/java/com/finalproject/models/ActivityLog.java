package com.finalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AcitivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;
    private String operation;
    private double duration;

    public AcitivityLog(Date date, String operation, double duration) {
        this.getId();
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}
