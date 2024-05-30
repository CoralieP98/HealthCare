package com.CoralieP98.patient.Service;

import com.CoralieP98.patient.Model.Patient;
import com.CoralieP98.patient.Repository.PatientRepository;
import com.CoralieP98.patient.Service.Form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PasswordEncoder passwordEncoder;

    private final PatientRepository patientRepository;

    public PatientService(PasswordEncoder passwordEncoder, PatientRepository patientRepository) {
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
    }

    public Patient registration(SignUpForm form){
        Patient patient = new Patient();
        patient.setUserName(form.getUserName());
        patient.setEmail(form.getEmail());
        patient.setPassword(passwordEncoder.encode(form.getPassword()));
        return patientRepository.save(patient);
    }


}
