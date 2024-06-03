package com.CoralieP98.patient.Controller;

import com.CoralieP98.patient.Model.User;
import com.CoralieP98.patient.Service.CustomService;
import com.CoralieP98.patient.Service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    private final CustomService customService;

    private final UserService userService;

    public UserController(CustomService customService, UserService userService) {
        this.customService = customService;
        this.userService = userService;

    }

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
