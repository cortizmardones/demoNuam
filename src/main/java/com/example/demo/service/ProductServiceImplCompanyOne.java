package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ResultBusinessLogic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ProductServiceImplCompanyOne implements ProductService {

    private static final String COMPANY_RUT = "76000002-1";

    @Override
    public boolean matchesCompanyRut(String companyRut) {
        return COMPANY_RUT.equals(companyRut);
    }

    @Override
    public ResultBusinessLogic applySpecificBusinessLogic(ProductRequest request) {

        log.info("Ejecutando lógica empresa 1 para companyRut={}", request.companyRut());

        //Call Store Procedure Postgres

        return ResultBusinessLogic.builder()
                .status("OK")
                .message("Ejecutando lógica empresa N° (1) para companyRut " + request.companyRut())
                .dateTime(LocalDateTime.now())
                .build();

    }
}

