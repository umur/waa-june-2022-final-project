package com.finalproject.service.impl;

import com.finalproject.models.User;
import com.finalproject.payload.request.PasswordChangeRequest;
import com.finalproject.repository.UserRepository;
import com.finalproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void changePass(long id, PasswordChangeRequest pwrreq) {
        var user = userRepo.findById(id);
        user.get().setPassword(encoder.encode(pwrreq.getPassword()));
        userRepo.save(user.get());
    }

    // added
    @Override
    public User findBYUserName(String name) {
        return userRepo.findByUsername(name).orElseThrow();
    }
}
