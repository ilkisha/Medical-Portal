package com.example.medportal.service.doctor;

import com.example.medportal.Command;
import com.example.medportal.model.Doctor;
import com.example.medportal.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteDoctorService implements Command<Integer, Void> {

    private final DoctorRepository doctorRepository;

    public DeleteDoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if (doctorOptional.isPresent()) {
            doctorRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return null;
    }
}
