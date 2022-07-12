package com.finalproject.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Applied {
    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection // 1
    @CollectionTable(name = "cv", joinColumns = @JoinColumn(name = "cvId")) // 2
    @Column(name = "cv") // 3
    private List<String> cv;
    private Integer contactNumber;

    private LocalDate dayofApplied;

    private boolean mark_delete;
    @ToString.Exclude
    @OneToOne

    private JobAdvertisement adverts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getCv() {
        return cv;
    }

    public void setCv(List<String> cv) {
        this.cv = cv;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getDayofApplied() {
        return dayofApplied;
    }

    public void setDayofApplied(LocalDate dayofApplied) {
        this.dayofApplied = dayofApplied;
    }

    public boolean isMark_deleteapplied() {
        return mark_delete;
    }

    public void setMark_delete(boolean mark_delete) {
        this.mark_delete = mark_delete;
    }

    public JobAdvertisement getAdverts() {
        return adverts;
    }

    public void setAdverts(JobAdvertisement adverts) {
        this.adverts = adverts;
    }

    public Applied(List<String> cv, Integer contactNumber) {
        this.cv = cv;
        this.contactNumber = contactNumber;
    }

    public Applied() {

    }
}
