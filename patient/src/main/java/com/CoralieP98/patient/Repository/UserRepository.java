package com.CoralieP98.patient.Repository;

import com.CoralieP98.patient.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query(value = "SELECT u FROM Patient u LEFT JOIN FETCH u.socialLinks WHERE u.email=:s")
//    public Optional<Patient> findUserByMail(String s);

    public Optional<User> findUserByEmail(String email);
}
