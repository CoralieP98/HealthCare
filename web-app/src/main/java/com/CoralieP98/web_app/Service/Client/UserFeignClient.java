package com.CoralieP98.web_app.Service.Client;

import com.CoralieP98.web_app.Model.Patient;
import com.CoralieP98.web_app.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@FeignClient("patient")
public interface UserFeignClient {

    @PostMapping(value = "/api/createUser", consumes = "application/json")
    public ResponseEntity<User> createUser(User userForm);

    @PostMapping(value = "/api/findUserByUsername", consumes = "application/json")
    public ResponseEntity<User> getUserByUserName (@RequestParam String email);

    @GetMapping(value = "/api/getAll",consumes = "application/json")
    public ResponseEntity<List<Patient>> getAllPatients();

    @PostMapping (value = "/api/createPatient", consumes = "application/json")
    public String createPatient(Patient patient);

    @PostMapping(value = "/api/findPatientById",consumes = "application/json")
    public ResponseEntity<Patient> findPatientById(@RequestParam Long id);

    @PutMapping(value = "/api/updatePatient",consumes = "application/json")
    public String updatePatient(@RequestParam Long id,Patient patient);//meh

    @DeleteMapping(value = "/api/deletePatient",consumes = "application/json")
    public void deletePatient(@PathVariable("id")Patient patient);






}
