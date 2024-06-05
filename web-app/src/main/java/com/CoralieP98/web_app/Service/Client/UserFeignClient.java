package com.CoralieP98.web_app.Service.Client;

import com.CoralieP98.web_app.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@FeignClient("patient")
public interface UserFeignClient {

    @PostMapping(value = "/api/createUser", consumes = "application/json")
    public ResponseEntity<User> createUser(User user);

    @PostMapping(value = "/api/findUserByUsername", consumes = "application/json")
    public ResponseEntity<User> getUserByUserName (@RequestParam String email);

    @GetMapping(value = "/api/findActualUser")
    public ResponseEntity<User> actualUser();



}
