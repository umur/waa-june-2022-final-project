package com.waa.amp.controller;

import com.waa.amp.dto.CheckUsernameReq;
import com.waa.amp.dto.CreateUserReq;
import com.waa.amp.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/registration")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/check-username")
    public ResponseEntity<?> checkUsername(@RequestBody CheckUsernameReq checkUsernameReq) {
        return ResponseEntity.ok(Map.of("exist", registrationService.checkUsername(checkUsernameReq)));
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserReq createUserReq) {
        return ResponseEntity.ok(Map.of("created", registrationService.createUser(createUserReq)));
    }
}
