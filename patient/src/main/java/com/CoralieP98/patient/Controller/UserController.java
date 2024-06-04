package com.CoralieP98.patient.Controller;

import com.CoralieP98.patient.Model.User;
import com.CoralieP98.patient.Service.CustomService;
import com.CoralieP98.patient.Service.UserService;
import jakarta.persistence.TableGenerator;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})

public class UserController {

    private final CustomService customService;

    private final UserService userService;

    public UserController(CustomService customService, UserService userService) {
        this.customService = customService;
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User userForm){
        return userService.createUser(userForm);
    }

    @PostMapping("/findUserByUserName")
    public



//    @PostMapping("/signUp")
//    public ModelAndView processRequest(@ModelAttribute("userForm")User userForm){
//        userService.registration(userForm);
//        return new ModelAndView("signIn");
//    }
//
//    @GetMapping("/signUp")
//    public ModelAndView showUserRegisterForm(){
//        return new ModelAndView("signUp", "userForm",new User());
//    }
//
//    @GetMapping("/profil")
//    public ModelAndView userProfil(Model model){
//        model.addAttribute("user",customService.actualUser());
//        return new ModelAndView("userProfil");
//    }
}
