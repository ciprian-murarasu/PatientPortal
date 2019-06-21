package com.sda.patientportal.repository;

import com.sda.patientportal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAll();

    Patient findByFirstName(String firstName);

    List<Patient> findAllByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

    Patient findByFirstNameAndLastName(String firstName, String lastName);

    Patient findByAge(Integer age);
}
