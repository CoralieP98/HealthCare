package com.CoralieP98.patient.Service;

import com.CoralieP98.patient.Model.User;
import com.CoralieP98.patient.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User createUsr(User userForm){
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        return userRepository.save(user);
    }

    public User createUser(User userForm){
        if (userRepository.findUserByEmail(userForm.getEmail()).isEmpty()){
            User user = new User();
            user.setEmail(userForm.getEmail());
            user.setPassword(passwordEncoder.encode(userForm.getPassword()));
            return userRepository.save(user);
        }else return userRepository.findUserByEmail(userForm.getEmail()).get();
    }


    public User findByUserName(String email){
        return userRepository.findUserByEmail(email).get();
    }


}
