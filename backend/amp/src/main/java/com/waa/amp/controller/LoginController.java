package com.waa.amp.controller;

import com.waa.amp.dto.LoginReq;
import com.waa.amp.entity.Role;
import com.waa.amp.entity.User;
import com.waa.amp.repository.UserRepository;
import com.waa.amp.security.JwtHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final JwtHelper jwtHelper;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginReq loginReq) {
        log.info("{}", loginReq);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.username(), loginReq.password()));
        User user = userRepository.findByEmail(loginReq.username()).orElseThrow(RuntimeException::new);
        List<String> roles = user.getRoles()
                .stream()
                .map(Role::getCode)
                .toList();

        var token = jwtHelper.createToken(loginReq.username(), roles);

        return ResponseEntity.ok(of("access_token", token,
                "username", user.getEmail(),
                "userType", user.getUserType().name()));
    }


}
