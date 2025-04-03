package com.example.medportal.service.patient;

import com.example.medportal.Query;
import com.example.medportal.model.Patient;
import com.example.medportal.model.PatientDTO;
import com.example.medportal.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetPatientsService implements Query<Void, List<PatientDTO>> {
    private final PatientRepository patientRepository;

    public GetPatientsService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public ResponseEntity<List<PatientDTO>> execute(Void input) {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDTO> patientDTOs = patients.stream()
                .map(PatientDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(patientDTOs);
    }
}
