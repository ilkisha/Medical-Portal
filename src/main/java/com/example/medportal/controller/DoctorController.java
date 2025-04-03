package com.example.medportal.controller;

import com.example.medportal.model.Doctor;
import com.example.medportal.model.DoctorDTO;
import com.example.medportal.model.UpdateDoctorCommand;
import com.example.medportal.service.doctor.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    private final CreateDoctorService createDoctorService;
    private final GetDoctorsService getDoctorsService;
    private final GetDoctorService getDoctorService;
    private final UpdateDoctorService updateDoctorService;
    private final DeleteDoctorService deleteDoctorService;

    public DoctorController(CreateDoctorService createDoctorService, GetDoctorsService getDoctorsService,
                            GetDoctorService getDoctorService,
                            UpdateDoctorService updateDoctorService, DeleteDoctorService deleteDoctorService) {
        this.createDoctorService = createDoctorService;
        this.getDoctorsService = getDoctorsService;
        this.getDoctorService = getDoctorService;
        this.updateDoctorService = updateDoctorService;
        this.deleteDoctorService = deleteDoctorService;
    }

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody Doctor doctor) {
        return createDoctorService.execute(doctor);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDTO>> getDoctors() {
       return getDoctorsService.execute(null);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Integer id) {
        return getDoctorService.execute(id);
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Integer id, @RequestBody Doctor doctor) {
        return updateDoctorService.execute(new UpdateDoctorCommand(id, doctor));
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
        return deleteDoctorService.execute(id);
    }
}
