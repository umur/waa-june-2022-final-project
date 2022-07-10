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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final JwtHelper jwtHelper;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginReq loginReq) {
        log.info("{}", loginReq);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.username(), loginReq.password()));

        List<String> roles = userRepository.findByEmail(loginReq.username())
                .map(User::getRoles)
                .map(r -> r.stream().map(Role::getRole).toList())
                .orElseThrow(RuntimeException::new);

        var token = jwtHelper.createToken(loginReq.username(), roles);

        return ResponseEntity.ok(Map.of("access_token", token));
    }


}
