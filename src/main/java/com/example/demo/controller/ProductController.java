package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ResultBusinessLogic;
import com.example.demo.service.ProductService;
import com.example.demo.service.factory.ProductServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceFactory productServiceFactory;

    @PostMapping
    public ResponseEntity<ResultBusinessLogic> createProduct(@RequestBody ProductRequest request) {

        //LLAMAS AL FACTORY (CAPA DE SERVICIO VAMOS A USAR)
        ProductService service = productServiceFactory.filterCompany(request.companyRut());

        //LLAMANDO Y RETORNANDO LA LOGICA DE NEGOCIO ESPECIFICA.
        return ResponseEntity.ok(service.applySpecificBusinessLogic(request));
    }
}
