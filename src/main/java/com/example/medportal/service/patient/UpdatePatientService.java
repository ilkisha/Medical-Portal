package com.example.medportal.service.patient;

import com.example.medportal.Command;
import com.example.medportal.model.Patient;
import com.example.medportal.model.PatientDTO;
import com.example.medportal.model.UpdatePatientCommand;
import com.example.medportal.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePatientService implements Command<UpdatePatientCommand, PatientDTO> {
    private final PatientRepository patientRepository;

    public UpdatePatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public ResponseEntity<PatientDTO> execute(UpdatePatientCommand command) {
        Optional<Patient> patientOptional = patientRepository.findById(command.getId());
        if (patientOptional.isPresent()) {
            Patient patient = command.getPatient();
            patient.setId(command.getId());
            patientRepository.save(patient);
            return ResponseEntity.ok(new PatientDTO(patient));
        }
        return ResponseEntity.notFound().build();
    }
}
