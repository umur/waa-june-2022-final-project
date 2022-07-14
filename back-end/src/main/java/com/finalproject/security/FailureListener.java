package com.finalproject.security;

import com.finalproject.models.User;
import com.finalproject.service.UserService;
import com.finalproject.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class FailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(FailureListener.class);

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        Object userName = event.getAuthentication().getPrincipal();
        User user = userService.getByUsername(userName.toString());

        if (user !=null) {
            if (user.isActive() && user.isAccountNonLocked()) {
                if (user.getFailedAttempt() < UserServiceImpl.MAX_FAILED_ATTEMPTS -1 ) {
                    userService.increaseFailedAttempts(user);
                } else {
                    userService.lock(user);
                    throw new LockedException("Your account has been locked due to 3 failed attempts."
                            + " It will be unlocked after 15 minutes.");
                }
            } else if(!user.isAccountNonLocked()) {
                if(userService.unlockWhenTimeExpired(user)) {
                    throw new LockedException("Your account has been unlocked. Please try to login again");
                }
            }
        }
    }
}
