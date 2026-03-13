package com.example.demo.exceptions;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record ErrorResponse(
        String code,
        String message,
        LocalDateTime dateTime
) {
}