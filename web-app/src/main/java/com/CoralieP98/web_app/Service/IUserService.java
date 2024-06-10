package com.CoralieP98.web_app.Service;


import com.CoralieP98.web_app.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User register(User user);

    public User findByUserName(String email);
}
