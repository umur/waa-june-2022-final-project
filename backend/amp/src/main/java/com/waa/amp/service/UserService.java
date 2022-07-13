package com.waa.amp.service;

import com.waa.amp.dto.ActiveUserReq;
import com.waa.amp.entity.User;
import com.waa.amp.repository.UserRepository;
import com.waa.amp.security.AmpUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getLoggedUser() {
        var principal = (AmpUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        User user = userRepository.findByEmail(username).orElseThrow(RuntimeException::new);
        return user;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .filter(it -> !it.getRoles().get(0).getCode().equalsIgnoreCase("ADMIN"))
                .toList();
    }

    public void activateUser(ActiveUserReq activeUserReq) {
        User user = userRepository.findById(activeUserReq.userId()).orElseThrow(() -> new RuntimeException("No user found"));
        user.setActive(activeUserReq.active());
        userRepository.save(user);
    }
}
