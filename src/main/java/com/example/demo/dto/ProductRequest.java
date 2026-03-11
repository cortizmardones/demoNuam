package com.example.demo.dto;

public record ProductRequest(

        String productName,
        Integer productPrice,
        String companyRut

) {
}