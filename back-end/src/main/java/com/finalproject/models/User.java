package com.finalproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  @JsonIgnore
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @Column(name = "isActive", columnDefinition = "BOOLEAN DEFAULT true")
  private boolean isActive;

  private String firstName;

  private String lastName;

  // softDelete

  @Column(insertable = false)
  private boolean soft_deleted = false;

  public boolean isSoft_deleted() {
    return soft_deleted;
  }

  public void setSoft_deleted(boolean soft_deleted) {
    this.soft_deleted = soft_deleted;
  }

  @Column(name="logged_at")
  private LocalDateTime last_logged;

//  @ToString.Exclude

  @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
  private Address address;

//  @ToString.Exclude
  @OneToOne(mappedBy = "user")
  private Student student;
  public User() {
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }
}
