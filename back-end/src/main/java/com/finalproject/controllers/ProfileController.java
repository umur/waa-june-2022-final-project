package com.finalproject.controllers;

import com.finalproject.models.Address;
import com.finalproject.models.User;
import com.finalproject.service.AddressService;
import com.finalproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/profile")
    public Optional<User> getMe() {
        return profileService.getMe();
    }

    @GetMapping("/profile/address")
    public Optional<Address> getAddress() { return addressService.getAddress();}

    @PutMapping("/profile/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
       return profileService.update(id, user);
    }
}
