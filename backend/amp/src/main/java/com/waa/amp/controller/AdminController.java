package com.waa.amp.controller;

import com.waa.amp.dto.ActiveUserReq;
import com.waa.amp.entity.User;
import com.waa.amp.service.EmailService;
import com.waa.amp.service.FacultyService;
import com.waa.amp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1/admin")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {

    private final UserService userService;
    private final FacultyService facultyService;
    private final EmailService emailService;

    @GetMapping("/test")
    public String test(Principal principal) {
        User loggedUser = userService.getLoggedUser();
        emailService.sendSimpleMessage("hasanat.muztaba@gmail.com", "TEST EMAIL", "SUP!");
        return "Test";
    }

    @GetMapping("/all-faculty")
    public ResponseEntity<?> getAllFaculty() {
        return ResponseEntity.ok(of("data", facultyService.allFaculty()));
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(of("data", userService.getAllUsers()));
    }

    @PostMapping("/active-user")
    public ResponseEntity<?> activateUser(@RequestBody ActiveUserReq activeUserReq) {
        userService.activateUser(activeUserReq);
        return ResponseEntity.ok(of("data", "ok"));
    }

}
