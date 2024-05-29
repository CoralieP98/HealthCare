package com.CoralieP98.web_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebAppController {

    @GetMapping("/")
    public String home(Model model){
        return "redirect:/home";
    }

    @GetMapping("/signIn")
    public ModelAndView signIn(){
        return new ModelAndView("signIn");
    }

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("homePage");
    }

//    @PostMapping("/signUp")
//    public ModelAndView processRequest(@ModelAttribute("signUpForm") SignUpForm form){
//        userService.registration(form);
//        return new ModelAndView("signIn");
//    }
//
//    @GetMapping("/signUp")
//    public ModelAndView showRegisterForm(){
//        return new ModelAndView("signUp", "signUpForm",new SignUpForm());
//    }

        @PostMapping("/signUp")
    public ModelAndView processRequest(){
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signUp");
    }
}
