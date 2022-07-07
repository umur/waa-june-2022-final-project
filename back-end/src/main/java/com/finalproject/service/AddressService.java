package com.finalproject.service;

import com.finalproject.models.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> getAddress();
}
