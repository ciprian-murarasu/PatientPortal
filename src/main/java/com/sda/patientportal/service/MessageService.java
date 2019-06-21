package com.sda.patientportal.service;

import com.sda.patientportal.model.Message;
import com.sda.patientportal.model.Message;
import com.sda.patientportal.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(Message message) {
        System.out.println("Message created");
        return messageRepository.save(message);
    }

    public Message get(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElse(null);
    }

    public List<Message> getAll() {
        return messageRepository.findAll();

    }

    public Message update(Message doctor) {
        return messageRepository.save(doctor);
    }

    public List<Message> getBySentDate(LocalDateTime sentDate) {
        return messageRepository.findBySentDate(sentDate);
    }
}
