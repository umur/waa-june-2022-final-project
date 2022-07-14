//package com.example.alumni.controller;
//
//
//import com.example.alumni.dto.request.LoginRequest;
//import com.example.alumni.dto.request.RegistrationRequest;
//import com.example.alumni.service.IUserService;
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
//
//    @Autowired
//    private IUserService iUserService;
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//        var login = iUserService.login(loginRequest);
//        System.out.println("signed in " + login);
//        return ResponseEntity.ok(login);
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest signUpRequest) {
//        var signUp = iUserService.signup(signUpRequest);
//        System.out.println("signed up or registered " + signUp);
//        return ResponseEntity.ok(signUp);
//    }
//}
