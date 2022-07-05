package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity@AllArgsConstructor@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    @Embedded
    private Address address;

    private Boolean active;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate lastLoggedInAt;
}
