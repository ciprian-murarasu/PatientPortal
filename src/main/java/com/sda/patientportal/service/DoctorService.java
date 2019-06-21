package com.sda.patientportal.service;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.model.Message;
import com.sda.patientportal.repository.DoctorRepository;
import com.sda.patientportal.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;
    private MessageRepository messageRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, MessageRepository messageRepository) {
        this.doctorRepository = doctorRepository;
        this.messageRepository = messageRepository;
    }

    public Doctor create(Doctor doctor) {
        System.out.println("Doctor created: " + doctor.getFirstName() + " " + doctor.getLastName());
        return doctorRepository.save(doctor);
    }

    public Doctor get(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();

    }

    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getByLastName(String lastName) {
        return doctorRepository.findByLastName(lastName);
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Message> getAllMessages(Long id){
        return messageRepository.findByReceiver(doctorRepository.findById(id));
    }

    public List<Message> getMessagesBySentDate(LocalDateTime sentDate) {
        return messageRepository.findBySentDate(sentDate);
    }
//    public Doctor findByParam(String param, String value) {
//        if (param.equals("firstName")) {
//            return doctorRepository.findByFirstName(value);
//        }
//        if (param.equals("lastName")) {
//            return doctorRepository.findByLastName(value);
//        }
//        if(param.equals("hospital")) {
//            return doctorRepository.findByHospital(value);
//        }
//    }
}
