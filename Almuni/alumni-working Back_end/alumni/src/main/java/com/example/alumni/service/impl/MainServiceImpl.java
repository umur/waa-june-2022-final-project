//package com.example.alumni.service.impl;
//
//
//import com.example.alumni.dto.request.LoginRequest;
//import com.example.alumni.dto.request.RegistrationRequest;
//import com.example.alumni.dto.response.LoginResponse;
//import com.example.alumni.dto.response.MessageResponse;
//import com.example.alumni.entity.ERole;
//import com.example.alumni.entity.Role;
//import com.example.alumni.entity.User;
//import com.example.alumni.repository.RoleRepository;
//import com.example.alumni.repository.UserRepository;
//import com.example.alumni.security.jwt.JwtUtils;
//import com.example.alumni.service.MainService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class MainServiceImpl implements MainService {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Override
//    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//        User user = userRepository.findByUsername(userDetails.getUsername()).orElse(null);
//        return ResponseEntity.ok(new LoginResponse(user.getUsername(),jwt));
//
//
////        return ResponseEntity.ok(new LoginResponse(
////               user.getUsername(),
////                user.getPassword()
//      //  ));
//    }
//
//    @Override
//    public ResponseEntity<MessageResponse> registerNewUser(RegistrationRequest signUpRequest) {
//
//        if (userRepository.existsByUsername(signUpRequest.getUserName())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Username is already taken!"));
//        }
//
//        if (userRepository.existsByEmail(signUpRequest.getUserName())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        User user = new User(
//                signUpRequest.getFirstName(),
//                signUpRequest.getLastName(),
//                signUpRequest.getUserName(),
//                 encoder.encode(signUpRequest.getPassword()),
//                new ArrayList<Role>());
//
//        String strRole = signUpRequest.getRole();
//
//        List<Role> roles = new ArrayList<>();
//
//        if (strRole == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            switch (strRole) {
//                case "ADMIN":
//                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(adminRole);
//                    break;
//                case "FACULTY":
//                    Role facultyRole = roleRepository.findByName(ERole.ROLE_FACULTY)
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(facultyRole);
//                    break;
//                default:
//                    Role studentRole = roleRepository.findByName(ERole.ROLE_STUDENT)
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(studentRole);
//            }
//        }
//        user.setRoles(roles);
//        userRepository.save(user);
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }
//}
