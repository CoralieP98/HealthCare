//package com.CoralieP98.patient.Service;
//
//import com.CoralieP98.patient.Model.User;
//import com.CoralieP98.patient.Repository.UserRepository;
//
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomService {
//
//    private final UserRepository userRepository;
//
//    public CustomService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    public User actualUser(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String actualUserName = authentication.getName();
//        User user = userRepository.findUserByEmail(actualUserName).get();
//        return user;
//    }
//}
