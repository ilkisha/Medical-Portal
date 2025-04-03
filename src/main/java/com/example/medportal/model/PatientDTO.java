package com.example.medportal.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;

    public PatientDTO(Patient patient) {
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.email = patient.getEmail();
        this.phone = patient.getPhone();
        this.dateOfBirth = patient.getDateOfBirth();
    }
}
