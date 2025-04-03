package com.example.medportal.service.doctor;

import com.example.medportal.Query;
import com.example.medportal.model.Doctor;
import com.example.medportal.model.DoctorDTO;
import com.example.medportal.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDoctorsService implements Query<Void, List<DoctorDTO>> {
    private final DoctorRepository doctorRepository;

    public GetDoctorsService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public ResponseEntity<List<DoctorDTO>> execute(Void input) {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOS = doctors
                .stream()
                .map(DoctorDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(doctorDTOS);
    }
}
