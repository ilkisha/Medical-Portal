package com.example.medportal.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Integer id;
    private Integer patientId;
    private Integer doctorId;
    private LocalDateTime appointmentDateTime;
    private String status;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.patientId = appointment.getPatient().getId();
        this.doctorId = appointment.getDoctor().getId();
        this.appointmentDateTime = appointment.getAppointmentDateTime();
        this.status = appointment.getStatus();
    }
}
