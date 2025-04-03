package com.example.medportal.service.appointment;

import com.example.medportal.Query;
import com.example.medportal.model.Appointment;
import com.example.medportal.model.AppointmentDTO;
import com.example.medportal.repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAppointmentService implements Query<Integer, AppointmentDTO> {
    private final AppointmentRepository appointmentRepository;

    public GetAppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ResponseEntity<AppointmentDTO> execute(Integer id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            return ResponseEntity.ok(new AppointmentDTO(appointmentOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
