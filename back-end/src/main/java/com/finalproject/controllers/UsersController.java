package com.finalproject.controllers;

import com.finalproject.models.User;
import com.finalproject.payload.request.PasswordChangeRequest;
import com.finalproject.payload.response.MessageResponse;
import com.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> resetPassword(@PathVariable long id, @RequestBody PasswordChangeRequest pwrreq){
        userService.changePass(id, pwrreq);
        return ResponseEntity.ok(new MessageResponse("Changed successfully"));
    }
}
