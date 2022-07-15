package com.waa.amp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    private String firstname;
    private String lastname;
    private String city;

    public Faculty(User user, String firstname, String lastname, String city) {
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
    }

}
