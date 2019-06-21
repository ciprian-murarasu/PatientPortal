package com.sda.patientportal.controller;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.model.Message;
import com.sda.patientportal.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        doctor.setId(null);
        return doctorService.create(doctor);
    }

    @GetMapping(value = "/{id}")
    public Doctor getById(@PathVariable Long id) {
        if (id != null) {
            return doctorService.get(id);
        }
        throw new RuntimeException("Id is missing");
    }

    @GetMapping
    public List<Doctor> getAll(@RequestParam(name = "lastname", required = false) String lastName) {
        if (lastName == null) {
            return doctorService.getAll();
        }
        return doctorService.getByLastName(lastName);
    }

    @PutMapping(value = "/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor) {
        if (doctorService.get(id) == null) {
            throw new RuntimeException("Doctor with id " + id + " doesn't exist");
        } else if (!id.equals(doctor.getId())) {
            throw new RuntimeException("Ids from endpoint and request body do not match");
        } else return doctorService.update(doctor);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (id != null) {
            doctorService.delete(id);
        } else throw new RuntimeException("Id is missing");
    }

    @GetMapping(value = "/{id}/messages")
    public List<Message> getAllMessages(@PathVariable Long id, @RequestParam(name = "sentdate", required = false) LocalDateTime sentDate) {
        if (sentDate == null) {
            return doctorService.getAllMessages(id);
        }
        return doctorService.getMessagesBySentDate(sentDate);
    }
}
