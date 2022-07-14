package com.finalproject.service.impl;

import com.finalproject.models.User;
import com.finalproject.payload.request.PasswordChangeRequest;
import com.finalproject.payload.request.VerifyCodeRequest;
import com.finalproject.payload.response.JwtResponse;
import com.finalproject.repository.UserRepository;
import com.finalproject.security.jwt.JwtUtils;
import com.finalproject.security.services.UserDetailsImpl;
import com.finalproject.service.TotpManager;
import com.finalproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public static final int MAX_FAILED_ATTEMPTS = 3;

    private static final long LOCK_TIME_DURATION = 900000; // 15 minutes

    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired private TotpManager totpManager;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

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

    @Override
    public ResponseEntity<?> verify(VerifyCodeRequest verifyCodeRequest, String code) {
        User user = userRepo.findByUsername(verifyCodeRequest.getUsername()).orElseThrow(() -> new RuntimeException( String.format("username %s", verifyCodeRequest.getUsername())));
        if(!totpManager.verifyCode(code, user.getSecret())) {
            System.out.println("Code is incorrect");
            return ResponseEntity.badRequest().body("nok");
        } else {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(verifyCodeRequest.getUsername(), verifyCodeRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            user.setLast_logged(LocalDateTime.now());
            userRepo.save(user);

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles,
                    userDetails.getMfa()));
        }
    }
}
