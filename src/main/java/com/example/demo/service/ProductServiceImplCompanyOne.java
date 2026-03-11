package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ResultBusinessLogic;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImplCompanyOne implements ProductService {

    private final static String COMPANY_RUT = "76000002-1";

    @Override
    public boolean validCompanyRut(String companyRut) {
        return COMPANY_RUT.equals(companyRut);
    }

    @Override
    public ResultBusinessLogic applySpecificBusinessLogic(ProductRequest request) {

        //Call Store Procedure Postgres

        return ResultBusinessLogic.builder()
                .status("OK")
                .message("Ejecutando lógica empresa N° (1) para companyRut " + request.companyRut())
                .dateTime(LocalDateTime.now())
                .build();

    }
}

