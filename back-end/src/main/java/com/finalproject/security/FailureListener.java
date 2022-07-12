package com.finalproject.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        Object userName = event.getAuthentication().getPrincipal();
        Object credentials = event.getAuthentication().getCredentials();
        LOG.debug("Failed login using USERNAME [" + userName + "]");
        LOG.debug("Failed login using PASSWORD [" + credentials + "]");
        System.out.println("Failed login using USERNAME [" + userName + "]");
        System.out.println("Failed login using PASSWORD [" + credentials + "]");
    }
}
