package com.CoralieP98.patient.Controller;

import com.CoralieP98.patient.Service.CustomService;
import com.CoralieP98.patient.Service.Form.SignUpForm;
import com.CoralieP98.patient.Service.PatientService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PatientController {

    private final CustomService customService;

    private final PatientService patientService;

    public PatientController(CustomService customService, PatientService patientService) {
        this.customService = customService;
        this.patientService = patientService;
    }

    @PostMapping("/signUp")
    public ModelAndView processRequest(@ModelAttribute("signUpForm") SignUpForm form){
        patientService.registration(form);
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signUp", "signUpForm",new SignUpForm());
    }

    @GetMapping("/profil")
    public ModelAndView patientProfil(Model model){
        model.addAttribute("patient",customService.actualPatient());
        return new ModelAndView("patientProfil");
    }
}
