package com.example.medportal.model;

import lombok.Getter;

@Getter
public class UpdateAppointmentCommand {
    private final Integer id;
    private final Appointment appointment;

    public UpdateAppointmentCommand(Integer id, Appointment appointment) {
        this.id = id;
        this.appointment = appointment;
    }
}
