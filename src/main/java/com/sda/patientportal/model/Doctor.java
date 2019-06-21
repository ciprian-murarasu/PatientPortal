package com.sda.patientportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull(message = "First name is missing")
    @Size(max = 20, min = 3, message = "Invalid first name")
    @Pattern(regexp = "^[A-Z].*")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name is missing")
    @Size(max = 20, min = 3, message = "Invalid last name")
    @Pattern(regexp = "^[A-Z].*")
    private String lastName;

    @Column(name = "hospital")
    @NotNull(message = "Hospital is missing")
    @Size(min = 3, message = "Invalid hospital")
    private String hospital;

    @OneToMany(mappedBy = "receiver")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "doctor")
    private List<TimeSlot> timeSlots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
