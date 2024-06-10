package com.CoralieP98.patient.Controller;

import com.CoralieP98.patient.Model.Patient;
import com.CoralieP98.patient.Model.User;
import com.CoralieP98.patient.Service.PatientService;
import com.CoralieP98.patient.Service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {
    private final UserService userService;

    private final PatientService patientService;

    public UserController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
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

    @GetMapping("getAll")
    public List<Patient> getAllPatients(){
       return patientService.getAllPatients();
    }

    @PostMapping("createPatient")
    public String createPatient(Patient patient){
        patientService.createPatient(patient);
        return "patient created";
    }

    @PostMapping("findPatientById")
    public Patient findPatientById(@RequestParam Long id){
        return patientService.findPatientById(id);
    }

    @PutMapping("updatePatient")
    public String updatePatient(@RequestParam Long id,Patient patient){
        return patientService.updatePatient(id,patient);

    }


}
