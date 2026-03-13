package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ResultBusinessLogic;
import com.example.demo.service.ProductService;
import com.example.demo.service.factory.ProductServiceFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductServiceFactory productServiceFactory;

    @PostMapping
    public ResponseEntity<ResultBusinessLogic> createProduct(@RequestBody ProductRequest request) {

        log.info("Request recibida createProduct() productName = {} , productPrice = {} , companyRut = {}", request.productName(), request.productPrice(), request.companyRut());

        //LLAMAS AL FACTORY (DECIDIR QUE IMPLEMENTACIÓN CONCRETA DEL SERVICIO VAMOS A USAR)
        ProductService productService = productServiceFactory.filterCompany(request.companyRut());

        return ResponseEntity.ok(productService.applySpecificBusinessLogic(request));
    }
}
