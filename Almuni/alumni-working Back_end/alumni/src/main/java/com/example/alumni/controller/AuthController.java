//package com.example.alumni.controller;
//
//
//import com.example.alumni.dto.request.LoginRequest;
//import com.example.alumni.dto.request.RegistrationRequest;
//import com.example.alumni.service.MainService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    private MainService mainService;
//    @PostMapping("/signin")
//    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
//        return mainService.authenticateUser(loginRequest);
//    }
//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@Valid @RequestBody RegistrationRequest signUpRequest) {
//       System.out.println("tekle sakit"+signUpRequest.getFirstName());
//         System.out.println("password "+signUpRequest.getPassword());
//
//        return mainService.registerNewUser(signUpRequest);
//    }
//}
