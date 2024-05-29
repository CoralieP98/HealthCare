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

    @PostMapping("/signUp")
    public ModelAndView processRequest(@ModelAttribute("signUpForm") SignUpForm form){
        userService.registration(form);
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signUp", "signUpForm",new SignUpForm());
    }
}
