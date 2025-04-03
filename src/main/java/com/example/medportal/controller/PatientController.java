package com.example.medportal.controller;

import com.example.medportal.model.Patient;
import com.example.medportal.model.PatientDTO;
import com.example.medportal.model.UpdatePatientCommand;
import com.example.medportal.service.patient.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    private final CreatePatientService createPatientService;
    private final GetPatientsService getPatientsService;
    private final GetPatientService getPatientService;
    private final UpdatePatientService updatePatientService;
    private final DeletePatientService deletePatientService;

    public PatientController(CreatePatientService createPatientService,
                             GetPatientsService getPatientsService,
                             GetPatientService getPatientService,
                             UpdatePatientService updatePatientService,
                             DeletePatientService deletePatientService) {
        this.createPatientService = createPatientService;
        this.getPatientsService = getPatientsService;
        this.getPatientService = getPatientService;
        this.updatePatientService = updatePatientService;
        this.deletePatientService = deletePatientService;
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody Patient patient) {
        return createPatientService.execute(patient);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> getPatients() {
        return getPatientsService.execute(null);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable Integer id) {
        return getPatientService.execute(id);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
        return updatePatientService.execute(new UpdatePatientCommand(id, patient));
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer id) {
        return deletePatientService.execute(id);
    }
}
