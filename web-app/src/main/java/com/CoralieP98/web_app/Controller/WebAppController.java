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
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/patient/update/{id}")
    public  String showUpdateForm(@PathVariable("id") Long id, Model model){
        Patient updatePatient = userFeignClient.findPatientById(id).getBody();
        model.addAttribute("patient", updatePatient);
        return "updatePatient";
    }

    @PostMapping("/patient/update/{id}")
    public String updatePatient(@PathVariable("id") Long id, Patient patient){
//        patient.setId(id);
        userFeignClient.updatePatient(id, patient);
        return "redirect:/patient/list";
    }
}
