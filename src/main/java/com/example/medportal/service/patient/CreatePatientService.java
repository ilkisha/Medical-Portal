package com.example.medportal.service.patient;

import com.example.medportal.Command;
import com.example.medportal.model.Patient;
import com.example.medportal.model.PatientDTO;
import com.example.medportal.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientService implements Command<Patient, PatientDTO> {
    private final PatientRepository patientRepository;

    public CreatePatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public ResponseEntity<PatientDTO> execute(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PatientDTO(savedPatient));
    }
}
