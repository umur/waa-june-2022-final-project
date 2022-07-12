package com.finalproject.service.impl;

import com.finalproject.models.User;
import com.finalproject.payload.request.PasswordChangeRequest;
import com.finalproject.repository.UserRepository;
import com.finalproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public static final int MAX_FAILED_ATTEMPTS = 3;

    private static final long LOCK_TIME_DURATION = 900000; // 15 minutes

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

    @Override
    public void deActivate(long id) {
        var user = userRepo.findById(id);
        user.get().setActive(false);
        userRepo.save(user.get());
    }

    @Override
    public void activate(long id) {
        var user = userRepo.findById(id);
        user.get().setActive(true);
        userRepo.save(user.get());
    }

    @Override
    public void increaseFailedAttempts(User user) {
        int newFailAttemps = user.getFailedAttempt() + 1;
        user.setFailedAttempt(newFailAttemps);
        userRepo.save(user);
        // userRepo.updateFailedAttempts(newFailAttemps, user.getEmail());
    }

    @Override
    public void resetFailedAttempts(String username) {
        userRepo.findByUsername(username).get().setFailedAttempt(0);
    }

    @Override
    public void lock(User user) {
        user.setAccountNonLocked(false);
        user.setLockTime(new Date());
        userRepo.save(user);
    }

    @Override
    public boolean unlockWhenTimeExpired(User user) {
        long lockTimeInMillis = user.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();

        if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
            user.setAccountNonLocked(true);
            user.setLockTime(null);
            user.setFailedAttempt(0);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User getByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User getByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("Error: User is not found"));
    }

    // added
    @Override
    public User findBYUserName(String name) {
        return userRepo.findByUsername(name).orElseThrow();
    }
}
