package com.example.demo.service.factory;

import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductServiceFactory {

    //ACÁ ES DONDE SE HACE LA MAGIA - SPRINGBOOT CARGA ESTO CON LAS 2 IMPLEMENTACIONES CONCRETAS POR NOSOTROS.
    private final List<ProductService> services;

    public ProductService filterCompany(String companyRut) {
        return services.stream()
                .filter(service -> service.matchesCompanyRut(companyRut))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe implementación para rutEmpresa: " + companyRut));
    }

}