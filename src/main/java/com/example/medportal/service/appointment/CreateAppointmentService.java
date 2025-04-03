package com.example.medportal.service.appointment;

import com.example.medportal.Command;
import com.example.medportal.model.Appointment;
import com.example.medportal.model.AppointmentDTO;
import com.example.medportal.repository.AppointmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointmentService implements Command<Appointment, AppointmentDTO> {
    private final AppointmentRepository appointmentRepository;

    public CreateAppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ResponseEntity<AppointmentDTO> execute(Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AppointmentDTO(savedAppointment));
    }
}
