package com.example.medportal.service.appointment;

import com.example.medportal.Command;
import com.example.medportal.model.Appointment;
import com.example.medportal.model.AppointmentDTO;
import com.example.medportal.model.UpdateAppointmentCommand;
import com.example.medportal.repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateAppointmentService implements Command<UpdateAppointmentCommand, AppointmentDTO> {

    private final AppointmentRepository appointmentRepository;

    public UpdateAppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ResponseEntity<AppointmentDTO> execute(UpdateAppointmentCommand command) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(command.getId());
        if (appointmentOptional.isPresent()) {
            Appointment appointment = command.getAppointment();
            appointment.setId(command.getId());
            appointmentRepository.save(appointment);
            return ResponseEntity.ok(new AppointmentDTO(appointment));
        }
        return ResponseEntity.notFound().build();
    }
}
