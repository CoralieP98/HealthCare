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
    public Patient createPatient(@RequestBody Patient patient){
        patientService.createPatient(patient);
        return patient;
    }

    @PostMapping("findPatientById")
    public Patient findPatientById(@RequestParam Long id){
        return patientService.findPatientById(id);
    }

//    @DeleteMapping("deletePatient")
//    public void deletePatient(@RequestParam Long id){
//        patientService.deletePatient(id);
//    }

    @DeleteMapping("deletePatient")
    public void deletePatient(@PathVariable("id")Patient patient){
        patientService.deletePatient(patient.getId());
    }


}
