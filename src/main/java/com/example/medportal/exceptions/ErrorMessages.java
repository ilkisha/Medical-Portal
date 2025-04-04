package com.example.medportal.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    PATIENT_NOT_FOUND("Patient Not Found");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
