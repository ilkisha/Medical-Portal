package com.example.medportal.model;

import lombok.Data;

@Data
public class DoctorDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private String specialization;

    public DoctorDTO(Doctor doctor) {
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.email = doctor.getEmail();
        this.phone = doctor.getPhone();
        this.specialization = doctor.getSpecialization();
    }
}
