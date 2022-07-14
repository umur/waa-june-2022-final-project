package com.example.alumni.service;


import com.example.alumni.dto.request.LoginRequest;
import com.example.alumni.dto.request.RegistrationRequest;
import com.example.alumni.dto.response.LoginResponse;
import com.example.alumni.dto.response.RegistrationResponse;

import java.util.List;

public interface IUserService<T,R,ID>{

    LoginResponse login(LoginRequest loginRequest);

    RegistrationResponse findByEmail(String email);

    void userIsActive(long id);

    List<RegistrationResponse> findAll();


    RegistrationResponse signup(RegistrationRequest userRegistration);

    RegistrationResponse findById(Long id);

}
