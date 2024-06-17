package com.CoralieP98.web_app.Controller;

import com.CoralieP98.web_app.Model.Patient;
import com.CoralieP98.web_app.Model.User;
import com.CoralieP98.web_app.Service.Client.UserFeignClient;

import com.CoralieP98.web_app.Service.CustomUserDetailsService;
import com.CoralieP98.web_app.Service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebAppController {

    private final UserFeignClient userFeignClient;

    private final UserServiceImpl userService;

    private final CustomUserDetailsService userDetailsService;


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
        userService.register(userForm);
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showUserForm(){
        return new ModelAndView("signUp", "userForm",new User());
    }

    @GetMapping("/profilHome")
    public String userProfilHome(String email){
        userDetailsService.loadUserByUsername(email);
        return "redirect:/home";
    }

    @PostMapping("/createPatient/valid")
    public String createPatient(@ModelAttribute("patient") Patient patient){
        userFeignClient.createPatient(patient);
        return "redirect:/patient/list";
    }

//    @PostMapping("/createPatient/valid")
//    public String createPatientOld(@ModelAttribute("patient") Patient patient, BindingResult result, Model model){
//        if (!result.hasErrors()){
//            userFeignClient.createPatient(patient);
////            model.addAttribute("patient",userFeignClient.getAllPatients());
//            return "redirect:/patient/list";
//        }
//        return "/createPatient";
//    }

    @GetMapping("/createPatient")
    public ModelAndView addPatient(Model model){
        model.addAttribute("patient", new Patient());
        return new ModelAndView("addPatient");
    }

    @GetMapping("/patient/list")
    public ModelAndView patientList(Model model){
        model.addAttribute("patients", userFeignClient.getAllPatients().getBody());
        return new ModelAndView("patients");
    }
}
