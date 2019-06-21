package com.sda.patientportal.repository;

import com.sda.patientportal.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAll();

    Doctor findByFirstName(String firstName);

    List<Doctor> findAllByFirstName(String firstName);

    List<Doctor> findByLastName(String lastName);

    Doctor findByFirstNameAndLastName(String firstName, String lastName);

    Doctor findByHospital(String hospital);
}
