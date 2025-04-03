package com.example.medportal.controller;

import com.example.medportal.model.Appointment;
import com.example.medportal.model.AppointmentDTO;
import com.example.medportal.model.UpdateAppointmentCommand;
import com.example.medportal.service.appointment.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    private final CreateAppointmentService createAppointmentService;
    private final GetAppointmentsService getAppointmentsService;
    private final GetAppointmentService getAppointmentService;
    private final UpdateAppointmentService updateAppointmentService;
    private final DeleteAppointmentService deleteAppointmentService;

    public AppointmentController(CreateAppointmentService createAppointmentService,
                                 GetAppointmentsService getAppointmentsService,
                                 GetAppointmentService getAppointmentService,
                                 UpdateAppointmentService updateAppointmentService,
                                 DeleteAppointmentService deleteAppointmentService) {
        this.createAppointmentService = createAppointmentService;
        this.getAppointmentsService = getAppointmentsService;
        this.getAppointmentService = getAppointmentService;
        this.updateAppointmentService = updateAppointmentService;
        this.deleteAppointmentService = deleteAppointmentService;
    }

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody Appointment appointment) {
        return createAppointmentService.execute(appointment);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAppointments() {
        return getAppointmentsService.execute(null);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Integer id) {
        return getAppointmentService.execute(id);
    }

    @PutMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Integer id, @RequestBody Appointment appointment) {
        return updateAppointmentService.execute(new UpdateAppointmentCommand(id, appointment));
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Integer id) {
        return deleteAppointmentService.execute(id);
    }
}
