package com.example.medportal.service.appointment;

import com.example.medportal.Query;
import com.example.medportal.model.Appointment;
import com.example.medportal.model.AppointmentDTO;
import com.example.medportal.repository.AppointmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAppointmentsService implements Query<Void, List<AppointmentDTO>> {
    private final AppointmentRepository appointmentRepository;

    public GetAppointmentsService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ResponseEntity<List<AppointmentDTO>> execute(Void input) {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOs = appointments.stream()
                .map(AppointmentDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(appointmentDTOs);
    }
}
