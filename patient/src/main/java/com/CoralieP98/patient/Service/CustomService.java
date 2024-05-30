package com.CoralieP98.patient.Service;

import com.CoralieP98.patient.Model.Patient;
import com.CoralieP98.patient.Repository.PatientRepository;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

    private final PatientRepository patientRepository;

    public CustomService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient actualPatient(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String actualPatientName = authentication.getName();
        Patient patient= patientRepository.findPatientByEmail(actualPatientName);
        return patient;
    }
}
