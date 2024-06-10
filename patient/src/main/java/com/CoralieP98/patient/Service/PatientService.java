package com.CoralieP98.patient.Service;

import com.CoralieP98.patient.Model.Patient;
import com.CoralieP98.patient.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public void createPatient(Patient patient){
        patientRepository.save(patient);
    }

    public Patient findPatientById(Long id){
        return patientRepository.findPatientById(id).get();
    }

    public Patient updatePatient(Long id, Patient patient){
        return patientRepository.save(id,patient);
    }
}
