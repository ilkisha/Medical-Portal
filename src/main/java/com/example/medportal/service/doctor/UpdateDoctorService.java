package com.example.medportal.service.doctor;

import com.example.medportal.Command;
import com.example.medportal.model.Doctor;
import com.example.medportal.model.DoctorDTO;
import com.example.medportal.model.UpdateDoctorCommand;
import com.example.medportal.repository.DoctorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateDoctorService implements Command<UpdateDoctorCommand, DoctorDTO> {
    private final DoctorRepository doctorRepository;

    public UpdateDoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public ResponseEntity<DoctorDTO> execute(UpdateDoctorCommand command) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(command.getId());

        if (doctorOptional.isPresent()) {
            Doctor doctor = command.getDoctor();
            doctor.setId(command.getId());
            doctorRepository.save(doctor);
            return ResponseEntity.ok(new DoctorDTO(doctor));
        }
        return null;
    }
}
