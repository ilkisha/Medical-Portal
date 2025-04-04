package com.example.medportal.service.patient;

import com.example.medportal.Command;
import com.example.medportal.exceptions.PatientNotFoundException;
import com.example.medportal.model.Patient;
import com.example.medportal.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePatientService implements Command<Integer, Void> {
    private final PatientRepository patientRepository;

    public DeletePatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            patientRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new PatientNotFoundException();
    }
}
