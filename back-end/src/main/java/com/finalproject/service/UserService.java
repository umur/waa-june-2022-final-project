package com.finalproject.service;

import com.finalproject.models.User;
import com.finalproject.payload.request.PasswordChangeRequest;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void changePass(long id, PasswordChangeRequest pwrreq);

    User findBYUserName( String name);

}
