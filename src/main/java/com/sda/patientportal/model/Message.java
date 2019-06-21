package com.sda.patientportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Question is missing")
    private String question;

    @NotNull(message = "Answer is missing")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Sender is missing")
    private Patient sender;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @NotNull(message = "Receiver is missing")
    private Doctor receiver;

    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime sentDate;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Patient getSender() {
        return sender;
    }

    public void setSender(Patient sender) {
        this.sender = sender;
    }

    public Doctor getReceiver() {
        return receiver;
    }

    public void setReceiver(Doctor receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
