package com.CoralieP98.patient.Repository;

import com.CoralieP98.patient.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
//    @Query(value = "SELECT u FROM Patient u LEFT JOIN FETCH u.socialLinks WHERE u.email=:s")
//    public Optional<Patient> findUserByMail(String s);

    public Patient findPatientByEmail(String email);
}
