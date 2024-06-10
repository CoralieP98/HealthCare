package com.CoralieP98.patient.Service;

import com.CoralieP98.patient.Model.Patient;
import com.CoralieP98.patient.Model.User;
import com.CoralieP98.patient.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(User userForm){
        userRepository.save(userForm);
    }

    public User createUserOld(User userForm){
        if (userRepository.findUserByEmail(userForm.getEmail()).isEmpty()){
            User user = new User();
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            return userRepository.save(user);
        }else return userRepository.findUserByEmail(userForm.getEmail()).get();
    }


    public User findByUserName(String email){
        return userRepository.findUserByEmail(email).get();
    }



}
