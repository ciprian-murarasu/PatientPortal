package com.sda.patientportal.service;

import com.sda.patientportal.model.Patient;
import com.sda.patientportal.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private PacientRepository patientRepository;

    @Autowired
    public PatientService(PacientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient create(Patient patient) {
        System.out.println("Patient created: " + patient.getFirstName() + " " + patient.getLastName());
        return patientRepository.save(patient);
    }

    public Patient get(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
