package com.finalproject.security;

import com.finalproject.models.User;
import com.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class SuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Object userName = event.getAuthentication().getName();
        User user = userService.getByUsername(userName.toString());
        if (user.getFailedAttempt() > 0) {
            userService.resetFailedAttempts(userName.toString());
        }
    }
}
