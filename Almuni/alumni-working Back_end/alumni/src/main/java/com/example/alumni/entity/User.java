package com.example.alumni.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    private String firstName;

    //@NotNull
    private String lastName;
    //@NotBlank
    //@Size(max = 50)
    //@Email
    private String email;

   // @NotBlank
    //@Size(max = 20)
    private String username;

    //@NotBlank
    //@Size(max = 120)
    private String password;

    private boolean isActive = true;

    //@Column(nullable = false)
    private String street;

    //@Column(nullable = false)
    private String city;

    private String state;

    private String zipcode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public User(String firstName, String lastName, String email,
                String username, String password,
                boolean active, boolean approvedSeller,
                LocalDate createdAt, LocalDate modifiedAt,
                String street, String city, String state, String zipcode,
                String cardName,
                List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isActive = active;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.roles = roles;
    }

    public User(String firstName, String lastName, String userName, String password, ArrayList<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.password = password;
        this.roles = roles;

    }
}
