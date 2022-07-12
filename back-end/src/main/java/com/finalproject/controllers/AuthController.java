package com.finalproject.controllers;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.finalproject.models.*;
import com.finalproject.payload.request.LoginRequest;
import com.finalproject.payload.request.SignupRequest;
import com.finalproject.payload.response.JwtResponse;
import com.finalproject.payload.response.MessageResponse;
import com.finalproject.repository.AddressRepository;
import com.finalproject.repository.RoleRepository;
import com.finalproject.repository.StudentRepo;
import com.finalproject.repository.UserRepository;
import com.finalproject.security.jwt.JwtUtils;
import com.finalproject.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  StudentRepo studentRepo;

  @Autowired
  AddressRepository addressRepo;
  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    String userName = loginRequest.getUsername();
    Optional<User> user1 = userRepository.findByUsername(userName);
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    if (user1.isPresent() && user1.get().isAccountNonLocked()) {
      System.out.println("yes its fine user");

      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtUtils.generateJwtToken(authentication);

      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      List<String> roles = userDetails.getAuthorities().stream()
              .map(item -> item.getAuthority())
              .collect(Collectors.toList());

      var user = userRepository.findById(userDetails.getId());
      user.get().setLast_logged(LocalDateTime.now());
      userRepository.save(user.get());

      return ResponseEntity.ok(new JwtResponse(jwt,
              userDetails.getId(),
              userDetails.getUsername(),
              userDetails.getEmail(),
              roles));
    } else if (user1.isPresent() && !user1.get().isAccountNonLocked()) {
        return ResponseEntity.badRequest().body(new MessageResponse("Error: Account is locked"));
    } else {
       return ResponseEntity.badRequest().body(new MessageResponse("Error: User is not found!"));
    }
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));



    Set<String> strRoles = Collections.singleton(signUpRequest.getRole());
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);
          break;
          case "student":
            Role studentRole = roleRepository.findByName(ERole.ROLE_STUDENT).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(studentRole);
          break;
          case "faculty":
            Role facultyRole = roleRepository.findByName(ERole.ROLE_FACULTY).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(facultyRole);
            break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    user.setActive(true);
    user.setFailedAttempt(0);

    User user1 = userRepository.save(user);
    // Create new student
    if (roles.stream().toList().get(0).getName().equals(ERole.ROLE_STUDENT)) {
      Student stu = new Student();
      stu.setUser(user1);
      studentRepo.save(stu);
    }

    // Create new address
    Address address = new Address();
    address.setUser(user1);
    addressRepo.save(address);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
