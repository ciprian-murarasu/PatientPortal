package com.sda.patientportal.controller;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.model.Message;
import com.sda.patientportal.model.Patient;
import com.sda.patientportal.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setId(null);
        return messageService.create(message);
    }

    @PutMapping(value = "/{id}")
    public Message update(@PathVariable Long id, @RequestBody Message message) {
        if (messageService.get(id) == null) {
            throw new RuntimeException("Message with id " + id + " doesn't exist");
        } else if (!id.equals(message.getId())) {
            throw new RuntimeException("Ids from endpoint and request body do not match");
        } else return messageService.update(message);
    }
}
