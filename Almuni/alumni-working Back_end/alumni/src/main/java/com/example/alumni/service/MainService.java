package com.example.alumni.service;




import com.example.alumni.dto.request.LoginRequest;
import com.example.alumni.dto.request.RegistrationRequest;
import com.example.alumni.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface MainService {

    ResponseEntity<MessageResponse> registerNewUser(RegistrationRequest signupRequest);

    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
}
