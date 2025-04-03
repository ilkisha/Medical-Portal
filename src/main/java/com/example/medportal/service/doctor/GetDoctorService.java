package com.example.medportal.service.doctor;

import com.example.medportal.Query;
import com.example.medportal.model.Doctor;
import com.example.medportal.model.DoctorDTO;
import com.example.medportal.repository.DoctorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetDoctorService implements Query<Integer, DoctorDTO> {
    private final DoctorRepository doctorRepository;

    public GetDoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public ResponseEntity<DoctorDTO> execute(Integer id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if (doctorOptional.isPresent()) {
            return ResponseEntity.ok(new DoctorDTO(doctorOptional.get()));
        }

        return null;
    }
}
