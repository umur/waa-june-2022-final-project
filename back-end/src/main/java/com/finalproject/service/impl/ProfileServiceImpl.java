package com.finalproject.service.impl;

import com.finalproject.models.User;
import com.finalproject.repository.UserRepository;
import com.finalproject.security.services.UserDetailsImpl;
import com.finalproject.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getMe() {
        Optional<User> me = Optional.of(new User());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetailsImpl) {
            Long id = ((UserDetailsImpl) principal).getId();
            me = userRepository.findById(id);
        }
        return me;
    }

    @Override
    public User update(Long id, User user) {
        var result = userRepository.findById(id);
        result.get().setFirstName(user.getFirstName());
        result.get().setLastName(user.getLastName());
        result.get().setAddress(user.getAddress());
        result.get().getAddress().setUser(userRepository.findById(id).get());
        return userRepository.save(result.get());
    }
}
