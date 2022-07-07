package com.finalproject.service;

import com.finalproject.models.Address;
import com.finalproject.models.User;

import java.util.Optional;

public interface ProfileService {

    Optional<User> getMe();

    User update(Long id, User user);
}
