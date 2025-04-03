package com.example.medportal.model;

import lombok.Getter;

@Getter
public class UpdatePatientCommand {
    private final Integer id;
    private final Patient patient;

    public UpdatePatientCommand(Integer id, Patient patient) {
        this.id = id;
        this.patient = patient;
    }
}
