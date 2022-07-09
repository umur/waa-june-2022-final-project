package com.finalproject.service.impl;

import com.finalproject.models.Address;
import com.finalproject.repository.AddressRepository;
import com.finalproject.security.services.UserDetailsImpl;
import com.finalproject.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<Address> getAddress() {
        Optional<Address> address = Optional.of(new Address());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetailsImpl) {
            Long id = ((UserDetailsImpl) principal).getId();
            address = addressRepository.findById(id);
        }
        return address;
    }
}
