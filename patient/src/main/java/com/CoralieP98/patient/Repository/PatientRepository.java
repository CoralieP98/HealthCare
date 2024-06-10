package com.CoralieP98.patient.Repository;

import com.CoralieP98.patient.Model.Patient;
import com.CoralieP98.patient.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public Optional<Patient> findPatientById(Long id);
}
