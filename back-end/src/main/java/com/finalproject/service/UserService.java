package com.finalproject.service;

import com.finalproject.models.User;
import com.finalproject.payload.request.LoginRequest;
import com.finalproject.payload.request.PasswordChangeRequest;
import com.finalproject.payload.request.VerifyCodeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    void changePass(long id, PasswordChangeRequest pwrreq);

    void deActivate(long id);

    void activate(long id);

    void increaseFailedAttempts(User user);

    void resetFailedAttempts(String email);

    void lock(User user);

    boolean unlockWhenTimeExpired(User user);

    User getByEmail(String email);

    User getByUsername(String username);

    User findBYUserName(String name);

    ResponseEntity<?> verify(VerifyCodeRequest verifyCodeRequest, String code);
}
