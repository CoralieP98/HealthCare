package com.CoralieP98.web_app.Service;

import com.CoralieP98.web_app.Model.User;
import com.CoralieP98.web_app.Service.Client.UserFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private final PasswordEncoder passwordEncoder;
    private final UserFeignClient userFeignClient;

    @Override
    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userFeignClient.createUser(user).getBody();
    }

    @Override
    public User findByUserName(String email){
        return userFeignClient.getUserByUserName(email).getBody();
    }
}
