package com.sda.patientportal.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany
//    @JoinColumn(name="id")
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

    @Column(name = "age")
    @NotNull(message = "Age is missing")
    @Range(min = 1, max = 100, message = "Age is outside range")
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
