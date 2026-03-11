package com.example.demo.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResultBusinessLogic (

        String status,
        String message,
        LocalDateTime dateTime

) {
}
