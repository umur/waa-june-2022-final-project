package com.waa.amp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private Boolean active = false;

}
