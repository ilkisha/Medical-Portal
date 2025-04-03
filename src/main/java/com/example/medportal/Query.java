package com.example.medportal;

import org.springframework.http.ResponseEntity;

public interface Query<I, O> {
    ResponseEntity<O> execute(I input);
}
