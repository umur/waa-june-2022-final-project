package com.waa.amp.service;

import com.waa.amp.entity.User;
import com.waa.amp.repository.UserRepository;
import com.waa.amp.security.AmpUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

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


}
