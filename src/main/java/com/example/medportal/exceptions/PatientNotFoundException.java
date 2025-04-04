package com.example.medportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException() {
        super(ErrorMessages.PATIENT_NOT_FOUND.getMessage());
    }
}
