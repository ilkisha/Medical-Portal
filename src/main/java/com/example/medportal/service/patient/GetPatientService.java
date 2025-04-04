package com.example.medportal.service.patient;

import com.example.medportal.Query;
import com.example.medportal.exceptions.PatientNotFoundException;
import com.example.medportal.model.Patient;
import com.example.medportal.model.PatientDTO;
import com.example.medportal.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPatientService implements Query<Integer, PatientDTO> {
    private final PatientRepository patientRepository;

    public GetPatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public ResponseEntity<PatientDTO> execute(Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            return ResponseEntity.ok(new PatientDTO(patientOptional.get()));
        }
        throw new PatientNotFoundException();
    }
}
