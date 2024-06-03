//package com.CoralieP98.web_app.Service.impl;
//
//import com.CoralieP98.web_app.Model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Override
//    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException{
//        User user = userService.findBayUserName(username);
//        if (user == null){
//            return null;
//        }
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getEmail())
//                .password(user.getPassword())
//                .roles(user.getRole().name())
//                .build();
//    }
//}
