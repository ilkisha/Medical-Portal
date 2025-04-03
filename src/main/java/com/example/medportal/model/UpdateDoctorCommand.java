package com.example.medportal.model;

import lombok.Getter;

@Getter
public class UpdateDoctorCommand {
    private final Integer id;
    private final Doctor doctor;

    public UpdateDoctorCommand(Integer id, Doctor doctor) {
        this.id = id;
        this.doctor = doctor;
    }
}
