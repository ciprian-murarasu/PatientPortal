package com.sda.patientportal.controller;

import com.sda.patientportal.model.Patient;
import com.sda.patientportal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

//    De mutat intr-un controllerDemo
//    @GetMapping(value = "/demo")
//    public String getDemo() {
//        return "Hello demo http get";
//    }
//
//    @PostMapping(value = "/demo", consumes = "application/json", produces = "application/txt")
//    public String postDemo() {
//        return "Hello demo http post";
//    }
//
//    @PostMapping(value = "/demo1")
//    public String postWithBodyDemo(@RequestBody String message) {
//        return "Hello demo http post with " + message;
//    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        patient.setId(null);
        return patientService.create(patient);
    }

    @GetMapping(value = "/{id}")
    public Patient getById(@PathVariable Long id) {
        if (id != null) {
            return patientService.get(id);
        }
        throw new RuntimeException("Id is missing");
    }

    @GetMapping
    public List<Patient> getAll(@RequestParam(name = "lastname", required = false) String lastName) {
        if (lastName == null) {
            return patientService.getAll();
        }
        return patientService.getByLastName(lastName);
    }

    @PutMapping(value = "/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        if (patientService.get(id) == null) {
            throw new RuntimeException("Patient with id " + id + " doesn't exist");
        } else if (!id.equals(patient.getId())) {
            throw new RuntimeException("Ids from endpoint and request body do not match");
        } else return patientService.update(patient);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (id != null) {
            patientService.delete(id);
        } else throw new RuntimeException("Id is missing");
    }
}
