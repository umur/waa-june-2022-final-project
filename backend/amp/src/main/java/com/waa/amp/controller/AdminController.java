package com.waa.amp.controller;

import com.waa.amp.entity.User;
import com.waa.amp.service.FacultyService;
import com.waa.amp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1/admin")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {

    private final UserService userService;
    private final FacultyService facultyService;

    @GetMapping("/test")
    public String test(Principal principal) {
        User loggedUser = userService.getLoggedUser();
        return "Test";
    }

    @GetMapping("/all-faculty")
    public ResponseEntity<?> getAllFaculty() {
        return ResponseEntity.ok(of("data", facultyService.allFaculty()));
    }

}
