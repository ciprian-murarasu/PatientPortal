package com.sda.patientportal.repository;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAll();

    List<Message> findBySentDate(LocalDateTime sentDate);

    List<Message> findByReceiver(Optional<Doctor> doctor);
}
