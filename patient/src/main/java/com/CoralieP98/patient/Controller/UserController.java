package com.CoralieP98.patient.Controller;

import com.CoralieP98.patient.Model.User;
import com.CoralieP98.patient.Service.UserService;
import jakarta.persistence.TableGenerator;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User userForm){
        userService.createUser(userForm);
        return userForm;
    }

    @PostMapping("/findUserByUsername")
    public User getUserByUsername(@RequestParam String email){
        return userService.findByUserName(email);
    }


}
