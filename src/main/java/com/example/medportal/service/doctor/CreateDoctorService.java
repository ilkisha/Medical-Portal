package com.example.medportal.service.doctor;

import com.example.medportal.Command;
import com.example.medportal.model.Doctor;
import com.example.medportal.model.DoctorDTO;
import com.example.medportal.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateDoctorService implements Command<Doctor, DoctorDTO> {

    private final DoctorRepository doctorRepository;

    public CreateDoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public ResponseEntity<DoctorDTO> execute(Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DoctorDTO(savedDoctor));
    }
}
