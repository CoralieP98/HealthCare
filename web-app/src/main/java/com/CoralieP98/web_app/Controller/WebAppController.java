package com.CoralieP98.web_app.Controller;

import com.CoralieP98.web_app.Model.User;
import com.CoralieP98.web_app.Service.Client.UserFeignClient;
import com.CoralieP98.web_app.Service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class WebAppController {

    private final UserServiceImpl userService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;


    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/")
    public String home(Model model){
        return "redirect:/home";
    }


    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("homePage");
    }

    @PostMapping("/signUp")
    public ModelAndView userSignUp(@ModelAttribute("userForm") User userForm){
        return userFeignClient.processRequest(userForm);
    }

    @GetMapping("/signUp")
    public ModelAndView showUserForm(){
        return userFeignClient.showUserForm();
    }

    @GetMapping("/logIn")
    public String getLogInPage(){return "signIn";}

}
