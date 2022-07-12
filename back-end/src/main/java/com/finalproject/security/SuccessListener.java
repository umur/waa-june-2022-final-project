package com.finalproject.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class MyListener1 implements ApplicationListener<AuthenticationSuccessEvent> {


    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        System.out.println("success");
    }
}
