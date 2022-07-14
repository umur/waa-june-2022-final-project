//package com.example.alumni.service.impl;
//
//
//
//import com.example.alumni.dto.user.UserDto;
//import com.example.alumni.entity.User;
//import com.example.alumni.repository.UserRepository;
//import com.example.alumni.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public List<UserDto> getAllStudents() {
//        List<User> sellers = userRepository.findAll();
//        sellers = sellers.stream()
//                .filter(s -> {
//                    List<String> roles = s.getRoles().stream().map(r -> r.getName().toString()).collect(Collectors.toList());
//                    return roles.contains("ROLE_SELLER");
//                })
//                .collect(Collectors.toList());
//
//        List<UserDto> returnSellers = new ArrayList<>();
//        for(User user : sellers){
//            List<String> roles = user.getRoles().stream()
//                    .map(r -> r.getName().toString())
//                    .collect(Collectors.toList());
//            returnSellers.add(new UserDto(
//                    user.getId(),
//                    user.getFirstName(),
//                    user.getLastName(),
//                    user.getUsername(),
//                    user.getEmail(),
//                    roles,
//                    user.isActive(),
//                    user.getStreet(),
//                    user.getCity(),
//                    user.getState(),
//                    user.getZipcode()
//            ));
//        }
//        return returnSellers;
//    }
//
//    @Override
//    public List<UserDto> getAllFaculty() {
//        List<User> buyers = userRepository.findAll();
//        buyers = buyers.stream()
//                .filter(s -> {
//                    List<String> roles = s.getRoles().stream().map(r -> r.getName().toString()).collect(Collectors.toList());
//                    return roles.contains("ROLE_BUYER");
//                })
//                .collect(Collectors.toList());
//
//        List<UserDto> returnBuyers = new ArrayList<>();
//        for(User user : buyers){
//            List<String> roles = user.getRoles().stream()
//                    .map(r -> r.getName().toString())
//                    .collect(Collectors.toList());
//            returnBuyers.add(new UserDto(
//                    user.getId(),
//                    user.getFirstName(),
//                    user.getLastName(),
//                    user.getUsername(),
//                    user.getEmail(),
//                    roles,
//                    user.isActive(),
//                    user.getStreet(),
//                    user.getCity(),
//                    user.getState(),
//                    user.getZipcode()
//            ));
//        }
//        return returnBuyers;
//    }
//
////    @Override
////    public List<UserDto> getUnapprovedSellers() {
////        List<User> sellers = userRepository.findByApprovedSeller(false);
////        sellers = sellers.stream()
////                .filter(s -> {
////                    List<String> roles = s.getRoles().stream().map(r -> r.getName().toString()).collect(Collectors.toList());
////                    return roles.contains("ROLE_SELLER");
////                })
////                .collect(Collectors.toList());
////
////        List<UserDto> returnSellers = new ArrayList<>();
////        for(User user : sellers){
////            List<String> roles = user.getRoles().stream()
////                    .map(r -> r.getName().toString())
////                    .collect(Collectors.toList());
////            returnSellers.add(new UserDto(
////                    user.getId(),
////                    user.getFirstName(),
////                    user.getLastName(),
////                    user.getUsername(),
////                    user.getEmail(),
////                    roles,
////                    user.isActive(),
////                    user.getStreet(),
////                    user.getCity(),
////                    user.getState(),
////                    user.getZipcode()
////            ));
////        }
////        return returnSellers;
////    }
//
//    @Override
//    public UserDto getUserById(Long id) {
//        User user = userRepository.findById(id).orElse(null);
//        List<String> roles = user.getRoles().stream()
//                .map(r -> r.getName().toString())
//                .collect(Collectors.toList());
//        return new UserDto(
//                user.getId(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getUsername(),
//                user.getEmail(),
//                roles,
//                user.isActive(),
//                user.getStreet(),
//                user.getCity(),
//                user.getState(),
//                user.getZipcode()
//        );
//    }
//
////    @Transactional
////    @Override
////    public void updateUser(ApproveDto approveDto) {
////        User user = userRepository.findById(approveDto.getId()).orElse(null);
////        user.setApprovedSeller(approveDto.isApprove());
////    }
//
////    @Override
////    public List<UserDto> getApprovedSellers() {
////        List<User> sellers = userRepository.findByApprovedSeller(true);
////        sellers = sellers.stream()
////                .filter(s -> {
////                    List<String> roles = s.getRoles().stream().map(r -> r.getName().toString()).collect(Collectors.toList());
////                    return roles.contains("ROLE_SELLER");
////                })
////                .collect(Collectors.toList());
////
////        List<UserDto> returnSellers = new ArrayList<>();
////        for(User user : sellers){
////            List<String> roles = user.getRoles().stream()
////                    .map(r -> r.getName().toString())
////                    .collect(Collectors.toList());
////            returnSellers.add(new UserDto(
////                    user.getId(),
////                    user.getFirstName(),
////                    user.getLastName(),
////                    user.getUsername(),
////                    user.getEmail(),
////                    roles,
////                    user.isActive(),
////                    user.getStreet(),
////                    user.getCity(),
////                    user.getState(),
////                    user.getZipcode()
////            ));
////        }
////        return returnSellers;
////    }
//}
