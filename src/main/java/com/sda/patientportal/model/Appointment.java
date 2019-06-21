package com.sda.patientportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    private Patient patient;
    private Doctor doctor;
    private TimeSlot timeSlot;
}
